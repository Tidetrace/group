package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.GoodsClasses;
import com.zhiyou.mall.mapper.GoodsClassesMapper;
import com.zhiyou.mall.service.Goods_classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Good_classesServiceImpl implements Goods_classesService {

    @Autowired
    private GoodsClassesMapper goodsClassesMapper;
    @Override
    public List<GoodsClasses> selectAll() {
        return goodsClassesMapper.selectAll();
    }

    @Override
    public int addclasses(String text) {
        return goodsClassesMapper.addclasses(text);
    }
    //二级分类显示中查询所有的一级分类
    @Override
    public List<GoodsClasses> selectShowClasses() {
        return goodsClassesMapper.selectShowClasses();
    }
    //添加二级分类
    @Override
    public int addSecondClasses(HashMap map) {
        return goodsClassesMapper.addSecondClasses(map);
    }
    //对商品分类进行编辑
    @Override
    public int editClasses(HashMap map) {
        return goodsClassesMapper.editClasses(map);
    }
    //批量删除
    @Override
    public void deleteClasses(int idDatum) {
        goodsClassesMapper.deleteClasses(idDatum);
    }
}
