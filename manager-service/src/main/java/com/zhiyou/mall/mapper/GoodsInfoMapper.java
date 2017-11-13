package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.GoodsInfo;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsInfoMapper extends Mapper<GoodsInfo> {
    public GoodsInfo queryGoodsInfoByUuid(String uuid);

}