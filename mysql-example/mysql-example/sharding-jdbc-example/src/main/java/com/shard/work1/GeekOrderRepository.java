package com.shard.work1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeekOrderRepository extends JpaRepository<GeekOrder, Long> {


}