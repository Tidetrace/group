package com.zhiyou.mall.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *Create by Tidetrace on 2017/11/10
 *desc:加入购物车
 */
@Controller
@RequestMapping("/shoppingCart")
public class shoppingCartController {
    @RequestMapping(value = "index/{good_uuid}",method = {RequestMethod.GET,RequestMethod.POST})
    public Object index(@PathVariable Integer good_uuid){
        System.out.println("进来了>>>>>>>>"+good_uuid);
        return "car/introduction";
    }

}
