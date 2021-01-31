package dao;

import com.lagou.RunBoot;
import com.lagou.entity.BOrder;
import com.lagou.entity.City;
import com.lagou.repository.BOrderRepository;
import com.lagou.repository.CityRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class TestHintAlgorithm {

    @Resource
    private CityRepository cityRepository;
    @Autowired
    private BOrderRepository orderRepository;

    @Test
    public void test1() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(0L); //强制路由到ds${xx%2}
        List<City> list = cityRepository.findAll();
        list.forEach(city -> {
            System.out.println(city.getId() + " " + city.getName() + " " + city.getProvince());
        });
    }

    @Test//路由库和表
    public void test() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("b_order", 1);
        hintManager.addTableShardingValue("b_order", 1);
        List<BOrder> list = orderRepository.findAll();
        hintManager.close();
        list.forEach(o -> {
            System.out.println(o.getCompanyId() + " " + o.getUserId() + " " );
        });
        hintManager.addDatabaseShardingValue("b_order", 0);
        hintManager.addTableShardingValue("b_order", 0);
         list = orderRepository.findAll();
        hintManager.close();
        list.forEach(o -> {
            System.out.println(o.getCompanyId() + " " + o.getUserId() + " " );
        });
    }

}
