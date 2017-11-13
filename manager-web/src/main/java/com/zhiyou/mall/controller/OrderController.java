package com.zhiyou.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.mall.entity.*;
import com.zhiyou.mall.service.GoodService;
import com.zhiyou.mall.service.OrderInfoService;
import com.zhiyou.mall.service.OrderService;
import com.zhiyou.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Tidetrace on 2017/11/3
 * desc:商品订单管理
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private GoodService goodService;

    /**
     * desc: 首次加载进入到主页面
     * return: 后台order界面
     */
    @RequestMapping("index.do")
    public Object orderSkip(Model model, @RequestParam(value = "seek", defaultValue = "") String seek, @RequestParam(value = "pageNum", defaultValue = "1") Integer page, @RequestParam(defaultValue = "2") Integer pageSize) {
        //分页查询，带有页码和长度
        PageHelper.startPage(page, pageSize);
        List<Order> orders = orderService.selectOrderAll(seek);
        PageInfo<Order> p = new PageInfo<Order>(orders);//将查询到的信息放到pageInfo实体类中
        //将查询到的信息和页码共享出去
        model.addAttribute("orders", orders);
        model.addAttribute("pageNum", p);
        System.out.println(p);
        return "order/order_index";
    }

    @RequestMapping("selectOrderByOrderNum.do")
    @ResponseBody
    public Object OrderByUserUuid(Model model, String orderNum) {
        OrderInfo orderInfo = orderInfoService.selectOrderByOrderNum(orderNum);
        Good good = goodService.selectOrderInfoByGoodUuid(orderInfo.getGoodUuid());
        model.addAttribute("good", good);
        Map map = new HashMap();
        map.put("mess", "商品编号:" + good.getGoodUuid());
        map.put("mess1", "商品标题：" + good.getGoodHead());
        map.put("mess2", "商品描述：" + good.getGoodDesc());
        map.put("mess3", "商品价格：" + good.getGoodPrice());
        return map;
    }

    /**
     * Create by Tidetrace on 2017/11/4
     * desc:修改买家留言
     */
    @RequestMapping("updateOrderByOrderNum.do")
    public Object updateOrderByOrderNum(String leaveWord, String orderNum) {
        int i = orderService.updateOrderByOrderNum(leaveWord,orderNum);
        return "redirect:/order/index.do";
    }

    /**
      * desc:
      * return:
      */
    @RequestMapping("deleteOrderByOrderNum.do")
    @ResponseBody
    public Object deleteOrderByOrderNum(String orderNum){
        int i = orderService.deleteOrderByOrderNum(orderNum);
        HashMap map = new HashMap();
        if(i>0) {
            map.put("ok", true);
        }else {
            map.put("err","修改错误");
        }
        return map;
    }

    /**
      * desc:批量删除
      * return: json数据，成功刷新页面，失败给出提示
      */

    @RequestMapping("delAllOrderByOM.do")
    @ResponseBody
    public Object delAllOrderByOM(int[] order_num, ModelMap map){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("order_num",order_num);
        System.out.println("批量删除》》》》"+order_num);
        int i = orderService.delAllOrderByOM(hashMap);
        if(i>0){
            map.put("success",true);
        }else {
            map.put("mess","删除失败");
        }
        return map;
    }
}
