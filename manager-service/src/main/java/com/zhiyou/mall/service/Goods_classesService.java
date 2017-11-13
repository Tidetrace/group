package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.GoodsClasses;

import java.util.HashMap;
import java.util.List;

public interface Goods_classesService {
    public List<GoodsClasses> selectAll();
    //添加商品分类
    public int addclasses(String text);
    //二级分类查询显示所有已经存在的一级分类
    public List<GoodsClasses> selectShowClasses();
    //添加二级分类
    public int addSecondClasses(HashMap map);
    //对商品分类进行编辑
     public int editClasses(HashMap map);
    //批量删除
    void deleteClasses(int idDatum);
}
