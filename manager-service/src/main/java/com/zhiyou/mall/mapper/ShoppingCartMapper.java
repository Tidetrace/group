package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.ShoppingCart;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper extends Mapper<ShoppingCart> {
    //根据用户Uuid查询购物车的信息
    public List<ShoppingCart> selectByUuid(String userUuid);
    //加入购物车
    public int insertCartInfo(Map map);
}