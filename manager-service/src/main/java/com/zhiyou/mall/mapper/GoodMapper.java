package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.Good;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodMapper extends Mapper<Good> {
    public Good selectOrderInfoByGoodUuid(String goodUuid);
    //与购物车关联懒加载查询
    public List<Good> selectShoppingCartInfoGood(String good_uuid);
}