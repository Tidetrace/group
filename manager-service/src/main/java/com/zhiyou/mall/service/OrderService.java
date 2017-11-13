package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    public List<Order> selectOrderAll(@Param(value = "seek") String seek);

    public int updateOrderByOrderNum(String leaveWord, String orderNum);

    public int deleteOrderByOrderNum(String orderNum);

    public int delAllOrderByOM(HashMap<String, Object> orderNums);
}
