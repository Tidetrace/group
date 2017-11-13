package com.zhiyou.mall.service;

import com.zhiyou.mall.entity.BResource;

import java.util.List;

public interface BResourceService {
    public List<BResource> seletBRAll(String seek);

    public BResource seletById(Integer id);

    public int updateById(BResource bResource);

    public int insertBR(Integer enable,String resourceName, String resourceUrl);

    public int deletBR(Integer id);
}
