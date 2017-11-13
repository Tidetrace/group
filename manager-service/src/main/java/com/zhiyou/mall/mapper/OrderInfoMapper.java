package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.OrderInfo;
import tk.mybatis.mapper.common.Mapper;

public interface OrderInfoMapper extends Mapper<OrderInfo> {
    public  OrderInfo selectOrderByOrderNum(String orderNum);
}