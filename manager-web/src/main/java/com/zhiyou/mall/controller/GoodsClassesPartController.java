package com.zhiyou.mall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhiyou.mall.entity.GoodsClasses;
import com.zhiyou.mall.entity.GoodsClassesPart;
import com.zhiyou.mall.service.GoodsClassesPartService;
import com.zhiyou.mall.service.Goods_classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/goodClassesPart")
public class GoodsClassesPartController {
    @Autowired
    private GoodsClassesPartService goodsClassesPartService;
    @Autowired
    private Goods_classesService goods_classesService;

    //跳转到分类模板页面
    @RequestMapping("show.do")
    public String goodsClassesPartShow(Model model){
        return "goods_classes_part/show";
    }
    //显示商品分类树
    @ResponseBody
    @RequestMapping("showTree.do")
    public Object goodsClassesPartShowTree(){

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
    //一进入页面显示其中一个的内容，使得内容表不空旷
    @RequestMapping("showdata.do")
    public String goodsClassesPartShowdata(Model model){
        List<GoodsClasses> goodsClasses=goods_classesService.selectAll();
        int a=0;
        //获取其中一个二级分类的id
        for (GoodsClasses gc: goodsClasses) {
            if(gc.getRank()==2){
                a=gc.getId();
                break;
            }
        }
        List<GoodsClassesPart> list= goodsClassesPartService.selectByRank(a);
        model.addAttribute("results",list);
        return "goods_classes_part/part_data";
    }
    //显示二级分类的模板说明
    @RequestMapping("showClassesPart.do")
    public String showClassesPart(Model model,int classId){
//        System.out.println(classId+"1111");
        List<GoodsClassesPart> list= goodsClassesPartService.selectByRank(classId);
        model.addAttribute("results",list);
        model.addAttribute("gclassesId",classId);
        return "goods_classes_part/part_data";
    }
    //根据模板显示具体的模板信息
    @ResponseBody
    @RequestMapping("showPartContent.do")
    public Object showPartContent(int id){
        HashMap map=new HashMap();
        GoodsClassesPart gcp=goodsClassesPartService.selectPartById(id);
        if(gcp!=null){
            map.put("success",true);
            map.put("data",gcp);
        }else{
            map.put("success",false);
            map.put("message","获取模板内容失败");
        }
        return map;
    }
    //添加模板信息
    @ResponseBody
    @RequestMapping("addPartContent.do")
    public Object addPartContent(String []parameter,int partid,String gcpartExplain){
        List<String> list=new ArrayList<String>();
        for(int i=0;i<parameter.length;i++){
            list.add(parameter[i]);
        }
        HashMap map=new HashMap();
        map.put("root",list);
        //将数据转换为json格式
        String json=JSON.toJSONString(map);
        GoodsClassesPart gcp=new GoodsClassesPart();
        gcp.setGclassesId(partid);
        gcp.setGcpartContent(json);
        gcp.setGcpartExplain(gcpartExplain);
        gcp.setCreateTime(new Date());

        //添加模板内容
        boolean b= goodsClassesPartService.addPart(gcp);
        HashMap m=new HashMap();
        if(b){
            m.put("success",true);
        }else{
            m.put("success",false);
            m.put("message","模板添加失败");
        }
        return m;
    }
    //编辑模板内容
    @ResponseBody
    @RequestMapping("editPartContent.do")
    public Object editPartContent(String []contentName,String content,Integer editPartId){
        List<String> list=new ArrayList<String>();
        for(int i=0;i<contentName.length;i++){
           list.add(contentName[i]);
        }
        HashMap map=new HashMap();
        map.put("root",list);
        //将数据装换为json数据
        String json=JSON.toJSONString(map);
        GoodsClassesPart gcp=new GoodsClassesPart();
        gcp.setCreateTime(new Date());
        gcp.setGcpartExplain(content);
        gcp.setGcpartContent(json);
        gcp.setId(editPartId);
        //获得当前id所对应的gclassesId
        GoodsClassesPart g=goodsClassesPartService.selectPartById(editPartId);
        //编辑模板内容
        boolean b=goodsClassesPartService.editPart(gcp);
        //返回json数据
        HashMap m=new HashMap();
        if(b){
            m.put("success",true);
            m.put("id",g.getGclassesId());
        }else{
            m.put("success",false);
            m.put("message","模板编辑失败");
        }

        return m;
    }
    //删除模板信息
    @ResponseBody
    @RequestMapping("deletePartContent.do")
    public Object deletePartContent(Integer id){
        GoodsClassesPart g=goodsClassesPartService.selectPartById(id);
        HashMap map=new HashMap();
        map.put("id",g.getGclassesId());
        boolean b=goodsClassesPartService.deletePartById(id);
        //获得当前id所对应的gclassesId
        if(b){
            map.put("success",true);
        }else{
            map.put("success",false);
            map.put("message","删除模板内容失败");
        }
        return map;
    }
    //批量删除
    @ResponseBody
    @RequestMapping("deleteClassesPartData.do")
    public Object deleteClassesPartData(int []idData,Integer gclassesId){
        HashMap map=new HashMap();
        for(int i=0;i<idData.length;i++){
            boolean b=goodsClassesPartService.deletePartData(idData[i]);
            if(b){
                map.put("success",true);
                map.put("id",gclassesId);
            }else{
                map.put("success",false);
                map.put("message","删除模板失败");
            }
        }
        return map;
    }
}
