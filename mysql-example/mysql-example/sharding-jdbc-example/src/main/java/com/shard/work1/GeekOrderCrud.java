package com.shard.work1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: lishuangqiang
 * @Date: 2021/12/26
 * @Description:
 */
@Service
public class GeekOrderCrud {

    @Autowired
    private GeekOrderRepository geekOrderRepository;

    public void insert(Long i) {
        GeekOrder geekOrder = new GeekOrder();
        geekOrder.setId(i);
        geekOrder.setOrderStatus(1);
        geekOrder.setPayStatus(1);
        geekOrder.setPayAmount(new Float(2.1));
        geekOrder.setBuyerName("买家");
        geekOrder.setBuyerPhone("123");
        geekOrder.setBuyerAddress("地址");
        geekOrder.setCreateAt(new Date());
        geekOrder.setUpdateAt(new Date());
        geekOrderRepository.save(geekOrder);
    }

    public void delete() {
        geekOrderRepository.deleteById(1L);
    }

    public void update() {
        List<GeekOrder> all = geekOrderRepository.findAll();
        for (GeekOrder geekOrder : all) {
            geekOrder.setBuyerName("买家update");
            geekOrderRepository.save(geekOrder);
        }
    }

    public void findAll() {
        List<GeekOrder> all = geekOrderRepository.findAll();
        all.stream().forEach(s -> System.out.println(s));
    }
}
