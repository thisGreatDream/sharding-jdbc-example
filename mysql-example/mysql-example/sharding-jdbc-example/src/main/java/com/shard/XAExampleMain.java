/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shard;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class XAExampleMain {
    //替换自己本地路径
    private static String configFile = "D:\\\\sharding-jdbc-example\\src\\main\\resources\\sharding-databases-tables.yaml";
//    private static String configFile = "/META-INF/sharding-databases-tables-postgresql.yaml";
//    private static String configFile = "/META-INF/master-slave.yaml";

    private static final String MYSQL_CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, address_id BIGINT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";

//    private static final String POSTGRESQL_CREATE_TABLE =
//        "CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT PRIMARY KEY NOT NULL, user_id INT NOT NULL, address_id BIGINT NOT NULL, status VARCHAR(50))";

    public static void main(final String[] args) throws SQLException, IOException, InterruptedException {
//        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(getFile(configFile));
        DataSource dataSource = getShardingDatasource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        initEnvironment(jdbcTemplate);
//        process(jdbcTemplate);
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO t_order (user_id, address_id, status) VALUES (?, ?, ?)";
        System.out.println("First XA Start insert data");

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            for (int i = 1; i < 11; i++) {
                statement.setInt(1, i);
                statement.setLong(2, i);
                statement.setString(3, "INIT");
                statement.executeUpdate();
            }
            conn.commit();


            System.out.println("First XA insert successful");
            System.out.println("Second XA Start insert data");

            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                conn.setAutoCommit(false);
                for (int i = 1; i < 11; i++) {
                    preparedStatement.setInt(1, i + 5);
                    preparedStatement.setLong(2, i + 5);
                    preparedStatement.setString(3, "INIT2");

                    preparedStatement.executeUpdate();
                }
                conn.commit();
            } catch (Exception e) {
                System.out.println("Second XA insert failed");
                conn.rollback();
            } finally {
                conn.close();
            }
            System.out.println("Second XA insert successful");
        }
    }


    private static File getFile(final String fileName) {
        return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
    }

    private static void initEnvironment(final JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("TRUNCATE TABLE t_order");
        jdbcTemplate.execute(MYSQL_CREATE_TABLE);
    }

    private static void process(final JdbcTemplate jdbcTemplate) throws InterruptedException {
        TransactionTypeHolder.set(TransactionType.XA);
        System.out.println("############### start commit transaction ################");
        jdbcTemplate.execute(new ConnectionCallback<Object>() {
            @Override
            public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
                connection.setAutoCommit(false);
                int result;
                try {
                    result = doInsert(connection);
                    printData(jdbcTemplate, "----------------- query all before commit ------------------");
                    connection.commit();
                    printData(jdbcTemplate, "----------------- query all after  commit ------------------");
                } catch (final SQLException ex) {
                    connection.rollback();
                    throw ex;
                }
                return result;
            }
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println("############### start rollback transaction ################");
        TransactionTypeHolder.set(TransactionType.XA);
        jdbcTemplate.execute(new ConnectionCallback<Object>() {
            @Override
            public Object doInConnection(final Connection connection) throws SQLException, DataAccessException {
                connection.setAutoCommit(false);
                doInsert2(connection);
                connection.rollback();
                printData(jdbcTemplate, "----------------- query all after rollback ------------------");
                return null;
            }
        });
    }

    private static int doInsert(final Connection connection) throws SQLException {
        int updateCount = 0;
        String sql = "INSERT INTO t_order (user_id, address_id, status) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setLong(2, i);
                preparedStatement.setString(3, "INIT");
                updateCount += preparedStatement.executeUpdate();
            }
            return updateCount;
        }
    }

    private static int doInsert2(final Connection connection) throws SQLException {
        int updateCount = 0;
        String sql = "INSERT INTO t_order (user_id, address_id, status) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setLong(2, i);
                preparedStatement.setString(3, "INIT2");
                updateCount += preparedStatement.executeUpdate();
            }
            return updateCount;
        }
    }

    private static void printData(final JdbcTemplate jdbcTemplate, final String title) {
        System.out.println(title);
        List<Map<String, Object>> data = jdbcTemplate.queryForList("SELECT * FROM t_order");
        if (data.isEmpty()) {
            System.out.println("t_order is empty");
            return;
        }
        for (Map<String, Object> each : data) {
            System.out.println(each.toString());
        }
    }


    static private DataSource getShardingDatasource() throws IOException, SQLException {
        File yamlFile = new File(configFile);
        return YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
    }
}
