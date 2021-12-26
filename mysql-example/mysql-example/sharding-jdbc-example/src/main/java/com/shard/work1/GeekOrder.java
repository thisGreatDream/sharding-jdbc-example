package com.shard.work1;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "geek_order")
public class GeekOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private int orderStatus;

    /**
     * 支付状态
     */
    @Column(name = "pay_status")
    private int payStatus;

    /**
     * 支付总金额
     */
    @Column(name = "pay_amount")
    private Float payAmount;

    /**
     * 买家名称
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 创建时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    private Date updateAt;

    public GeekOrder() {
    }

}