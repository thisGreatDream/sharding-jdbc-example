package com.lagou.repository;

import com.lagou.entity.BOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BOrderRepository extends JpaRepository<BOrder,Long> {
    @Query
    public List<BOrder>  findAllByIdAndCompanyId(long id,Integer companyId);
}
