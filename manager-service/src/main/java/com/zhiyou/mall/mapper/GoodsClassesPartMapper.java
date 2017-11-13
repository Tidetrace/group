package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.GoodsClassesPart;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsClassesPartMapper extends Mapper<GoodsClassesPart> {
    //进入页面显示数据
    public List<GoodsClassesPart> selectByRank(int a);
    //获取二级分类的模板内容
    public GoodsClassesPart selectPartById(int id);
    //添加模板内容
    public boolean addPart(GoodsClassesPart gcp);
    //编辑模板内容
    public boolean editPart(GoodsClassesPart gcp);
    //删除模板内容
    public boolean deletePartById(Integer id);
    //批量删除
    public boolean deletePartData(int idData);

    //根据商品的参数模板id查询商品参数
    public GoodsClassesPart selectByGModelId(Integer gModelId);
}