package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.GoodsClasses;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface GoodsClassesMapper extends Mapper<GoodsClasses> {
    public List<GoodsClasses> selectAll();
    //添加商品分类
    public int addclasses(String text);
//    二级分类中显示所有的一级分类
    public List<GoodsClasses> selectShowClasses();
    //添加二级分类
    public int addSecondClasses(HashMap map);
    //对商品分类进行编辑
    public int editClasses(HashMap map);
    //批量删除
    void deleteClasses(int idDatum);
    //与商品关联懒加载
    public GoodsClasses selectShoppingCartInfoGood(Integer g_class_id);
}