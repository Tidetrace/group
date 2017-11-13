package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.Order;
import com.zhiyou.mall.mapper.OrderMapper;
import com.zhiyou.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectOrderAll(String seek) {
        System.out.println("service>>>>>>>"+seek);
        return orderMapper.selectAlls(seek);
    }

    @Override
    public int updateOrderByOrderNum(String leaveWord, String orderNum) {
        HashMap hashMap = new HashMap();
        hashMap.put("leaveWord",leaveWord);
        hashMap.put("orderNum",orderNum);
        return orderMapper.updateOrderByOrderNum(hashMap);
    }

    @Override
    public int deleteOrderByOrderNum(String orderNum) {
        return orderMapper.deleteOrderByOrderNum(orderNum);
    }

    @Override
    public int delAllOrderByOM(HashMap<String, Object> orderNums) {
        return orderMapper.delAllOrderByOM(orderNums);
    }
}
