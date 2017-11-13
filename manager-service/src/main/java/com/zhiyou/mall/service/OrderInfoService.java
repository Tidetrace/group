package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.OrderInfo;

public interface OrderInfoService {
   public OrderInfo selectOrderByOrderNum(String orderNum);
}
