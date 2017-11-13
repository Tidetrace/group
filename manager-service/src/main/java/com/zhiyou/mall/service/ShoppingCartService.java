package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.Good;
import com.zhiyou.mall.entity.ShoppingCart;

import java.util.Date;
import java.util.List;

public interface ShoppingCartService {
    //根据Uuid查询购物车的信息
    public List<ShoppingCart> selectByUuid(String userUuid);

    public Good selectByGoodUuid(String goodUuid);
    //将购物信息加入购物车
    public int insertCartInfo(String userUuid, String goodUuid, Double goodSales, Integer number, Date date);
}
