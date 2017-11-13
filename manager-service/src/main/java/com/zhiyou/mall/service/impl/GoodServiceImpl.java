package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.Good;
import com.zhiyou.mall.mapper.GoodMapper;
import com.zhiyou.mall.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    /**
      * desc:根据OrderInfo表的goodUuid查询
      * return: Good表对应的信息
      */

    @Override
    public Good selectOrderInfoByGoodUuid(String goodUuid) {
        return goodMapper.selectOrderInfoByGoodUuid(goodUuid);
    }
}
