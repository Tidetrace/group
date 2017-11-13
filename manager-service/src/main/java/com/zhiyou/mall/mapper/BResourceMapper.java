package com.zhiyou.mall.mapper;

import com.zhiyou.mall.entity.BResource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BResourceMapper extends Mapper<BResource> {
    public List<BResource> selectBRAll(String seek);

    public BResource seletById(Integer id);

    public int updateById(BResource bResource);

    public int insertBR(Map hashMap);

    public int deletBR(Integer id);
}