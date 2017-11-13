package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.BUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BUserMapper extends Mapper<BUser>{

   //根据用户名密码查询后台用户查询信息封装为hashmap
   public BUser login(BUser buser)throws Exception;
   //根据查询用户名判断账号是否存在
    public BUser select1(String username);
    //获取角色信息
    public List<BUser> validateUserInfo(String username);


}