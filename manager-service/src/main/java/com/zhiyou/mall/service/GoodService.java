package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.Good;

public interface GoodService {
   public Good selectOrderInfoByGoodUuid(String goodUuid);
}
