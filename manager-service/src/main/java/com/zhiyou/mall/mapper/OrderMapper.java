package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.Order;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    public List<Order> selectAlls(@Param(value = "seek") String seek);

    public int updateOrderByOrderNum(HashMap hashMap);

    public int deleteOrderByOrderNum(String orderNum);

    public int delAllOrderByOM(HashMap<String, Object> orderNums);
}