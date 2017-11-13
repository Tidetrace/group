package com.zhiyou.mall.controller;

import com.zhiyou.mall.entity.GoodsClasses;
import com.zhiyou.mall.service.Goods_classesService;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodClasses")
public class Good_classesController {

    @Autowired
    private Goods_classesService goods_classesService;
    //获取商品分类维护页面
    @RequestMapping("show.do")
    public String show(Model model){
        List<GoodsClasses> goodsClasses= goods_classesService.selectShowClasses();
//        for (GoodsClasses gc:goodsClasses){
//            System.out.println(gc.getClassesName());
//        }
       model.addAttribute("goodsClass",goodsClasses);
        return "goods_classes/show";
    }
    //ajax获取商品分类
    @ResponseBody
    @RequestMapping("showTree.do")
    public Object showTree(){

       List<GoodsClasses> goodsClasses=goods_classesService.selectAll();
//        System.out.println(goodsClasses);
        List<Map> resultList=new ArrayList<Map>();
        for (GoodsClasses gc:goodsClasses) {
            HashMap map=new HashMap();
            map.put("id",gc.getId());
            map.put("pid",gc.getParentId());
            map.put("name",gc.getClassesName());
            resultList.add(map);
        }
        return resultList;
    }

    //添加商品分类
    @RequestMapping("addClasses.do")
    public String addclasses(String text){
        System.out.println(text);
//        HashMap map=new HashMap();
//        map.put("id",id);
//        map.put("text",text);
//        map.put("classesname",classesName);
     int i=goods_classesService.addclasses(text);
        return "redirect:show.do";
    }
    //页面显示一级商品分类。。......
    @ResponseBody
    @RequestMapping("addSecondClasses.do")
    public Object showClasses(String text,int id){
        HashMap map=new HashMap();
        map.put("classesName",text);
        map.put("parentId",id);
       int i= goods_classesService.addSecondClasses(map);
        return null;
    }
    //对商品进行名字的编辑
    @ResponseBody
    @RequestMapping("editClasses.do")
    public Object editClasses(String className,int id){
//        System.out.println(className+":"+id+"1111111111111111");
        HashMap map=new HashMap();
        map.put("className",className);
        map.put("id",id);
        int i = goods_classesService.editClasses(map);
        return null;
    }
    //删除商品分类
    @ResponseBody
    @RequestMapping("deleteClasses.do")
    public Object deleteClasses(int []idData){
        System.out.println(idData+"11111111111");
        for (int i=idData.length-1;i>=0;i--){
            goods_classesService.deleteClasses(idData[i]);
        }
        return null;
    }

}
