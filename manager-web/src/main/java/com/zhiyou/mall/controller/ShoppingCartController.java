package com.zhiyou.mall.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyou.mall.entity.Good;
import com.zhiyou.mall.entity.ShoppingCart;
import com.zhiyou.mall.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Create by Tidetrace on 2017/11/10
 * desc:加入购物车
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * desc:根据商品的uuid查询商品的信息
     * return: 商品信息Good的Entity类
     */
    @RequestMapping(value = "index/{good_uuid}", method = {RequestMethod.GET, RequestMethod.POST})
    public Object index(@PathVariable("good_uuid") String goodUuid, Model model) {
        Good goods = shoppingCartService.selectByGoodUuid(goodUuid);
        //将结果{"root":["包装","尺寸","颜色","白条分期"]}转化为json对象
        String json = JSON.toJSONString(goods.getGoodsClassesPart().getGcpartContent());
        //截取字符串并且把\替换为空格
        String str = json.substring(12, json.length() - 3).replace("\\", "");
        //按照逗号分割字符串
        String[] ss = str.split(",");
        //将其共享到页面
        model.addAttribute("ss", ss);
        model.addAttribute("goods", goods);
        return "car/introduction";
        //return "car/aa";
    }
    /**
      * desc:添加商品到购物车
      * return: json的显示的成功或者失败信息
      */
    @RequestMapping(value = "addCart/{good_uuid}", method = RequestMethod.POST)
    @ResponseBody
    public Object addCart(@PathVariable("good_uuid") String goodUuid,
                          @RequestParam Double goodSales, @RequestParam Integer number,
                          Model model) {
        System.out.println("添加购物车：>>>>>>>>" + goodUuid+"&&"+goodSales+":"+number);
        String userUuid="123456";
        int i = shoppingCartService.insertCartInfo(userUuid,goodUuid,goodSales,number,new Date());
        HashMap hashMap = new HashMap();
        if(i>0){
            hashMap.put("success",true);
        }else {
            hashMap.put("mess","加入购物车失败！");
        }
        return hashMap;
    }

    //跳转购物车首页
    @RequestMapping("show.do")
    public String showShoppingCart(Model model){
        String userUuid="123456";
        List<ShoppingCart> list=shoppingCartService.selectByUuid(userUuid);
        model.addAttribute("cartList",list);
        /*for (ShoppingCart s: list) {
            List<Good> g=s.getGood();
            for (Good good:g) {
                GoodsClasses gc=good.getGoodsClasses();
            }
        }*/
        return "car/show";
    }
}
