package com.shard.repository;

import com.shard.entity.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CUserRepository extends JpaRepository<CUser,Long> {

    public List<CUser> findByPwd(String pwd);

}
