1、分库分表的sql

CREATE TABLE `geek_order0` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';

CREATE TABLE `geek_order1` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order2` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order3` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order4` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order5` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order6` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';
CREATE TABLE `geek_order7` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';

CREATE TABLE `geek_order8` (
                             `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `order_status` TINYINT(4) NOT NULL COMMENT '订单状态',
                             `pay_status` TINYINT(4) DEFAULT NULL COMMENT '支付状态',
                             `pay_amount` FLOAT DEFAULT NULL COMMENT '支付总金额',
                             `buyer_name` VARCHAR(100) DEFAULT NULL COMMENT '买家名称',
                             `buyer_phone` VARCHAR(20) DEFAULT NULL COMMENT '买家电话',
                             `buyer_address` VARCHAR(100) DEFAULT NULL COMMENT '买家地址',
                             `create_at` DATETIME DEFAULT NULL COMMENT '创建时间',
                             `update_at` DATETIME DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单主表';



2、xa的sql：

CREATE TABLE `t_order_0` (
                           `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `user_id` int(11) NOT NULL,
                           `address_id` bigint(20) NOT NULL,
                           `status` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8
CREATE TABLE `t_order_1` (
                           `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `user_id` int(11) NOT NULL,
                           `address_id` bigint(20) NOT NULL,
                           `STATUS` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`order_id`),
                           UNIQUE KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8


以上两段sql都要在两个库都执行
