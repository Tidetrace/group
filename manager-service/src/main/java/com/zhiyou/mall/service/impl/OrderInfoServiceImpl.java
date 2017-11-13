package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.OrderInfo;
import com.zhiyou.mall.mapper.OrderInfoMapper;
import com.zhiyou.mall.mapper.OrderMapper;
import com.zhiyou.mall.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    /**
     * desc:根据Order表的orderNum查询
     * return:OrderInfo集合
     */
    @Override
    public OrderInfo selectOrderByOrderNum(String orderNum) {
        return orderInfoMapper.selectOrderByOrderNum(orderNum);
    }
}
