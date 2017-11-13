package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.GoodsClassesPart;
import com.zhiyou.mall.mapper.GoodsClassesPartMapper;
import com.zhiyou.mall.service.GoodsClassesPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsClassesPartServiceImpl implements GoodsClassesPartService {

    @Autowired
    private GoodsClassesPartMapper goodsClassesPartMapper;

    //进入页面显示数据
    @Override
    public List<GoodsClassesPart> selectByRank(int a) {
        System.out.println(">>>>>>>>>>>>>serviceIpml层");
        List<GoodsClassesPart> list= goodsClassesPartMapper.selectByRank(a);
       /* for (GoodsClassesPart g:
             list) {
            System.out.println(g.getGcpartExplain());
        }*/
        return list;
    }
    //获取二级分类的模板内容
    @Override
    public GoodsClassesPart selectPartById(int id) {
        return goodsClassesPartMapper.selectPartById(id);
    }
    //添加模板内容
    @Override
    public boolean addPart(GoodsClassesPart gcp) {
        return goodsClassesPartMapper.addPart(gcp);
    }
    //编辑模板内容
    @Override
    public boolean editPart(GoodsClassesPart gcp) {
        return goodsClassesPartMapper.editPart(gcp);
    }
    //删除模板内容
    @Override
    public boolean deletePartById(Integer id) {
        return goodsClassesPartMapper.deletePartById(id);
    }
    //批量删除
    @Override
    public boolean deletePartData(int idData) {
        return goodsClassesPartMapper.deletePartData(idData);
    }
}
