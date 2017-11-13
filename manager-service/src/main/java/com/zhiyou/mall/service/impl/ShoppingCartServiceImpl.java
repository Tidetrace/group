package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.Good;
import com.zhiyou.mall.entity.ShoppingCart;
import com.zhiyou.mall.mapper.GoodMapper;
import com.zhiyou.mall.mapper.ShoppingCartMapper;
import com.zhiyou.mall.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Create by Tidetrace on 2017/11/11
 *desc:加入购物车服务层
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    //根据用户Uuid查询购物车的信息
    @Override
    public List<ShoppingCart> selectByUuid(String userUuid) {
        return shoppingCartMapper.selectByUuid(userUuid);
    }

    /**
      * desc:根据商品的uuid查询商品的信息
      * return: 商品信息Good的Entity类
      */
    public Good selectByGoodUuid(String goodUuid) {
        return goodMapper.selectOrderInfoByGoodUuid(goodUuid);
    }
    /**
      * desc:加入购物车
      * return: 成功 1 失败 0
      */
    @Override
    public int insertCartInfo(String userUuid, String goodUuid, Double goodSales, Integer number, Date date) {
        Map map = new HashMap();
        map.put("userUuid",userUuid);
        map.put("goodUuid",goodUuid);
        map.put("goodSales",goodSales);
        map.put("number",number);
        map.put("createTime",date);
        System.out.println("咔咔咔》》》》》》》》》》》");
        return shoppingCartMapper.insertCartInfo(map);
    }
}
