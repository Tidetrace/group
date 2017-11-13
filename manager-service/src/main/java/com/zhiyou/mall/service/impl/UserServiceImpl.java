package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.OrderInfo;
import com.zhiyou.mall.entity.User;
import com.zhiyou.mall.mapper.AdminDemoMapper;
import com.zhiyou.mall.mapper.UserMapper;
import com.zhiyou.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


}