package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.OrderInfo;
import com.zhiyou.mall.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

   public OrderInfo selectByUserUuid(String userUuid);
}