package com.zhiyou.mall.service.impl;

import com.zhiyou.mall.entity.BResource;
import com.zhiyou.mall.mapper.BResourceMapper;
import com.zhiyou.mall.service.BResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Create by Tidetrace on 2017/11/9
 *desc:权限信息管理的Service层
 */
@Service
public class BResourceServiceImpl implements BResourceService {
    @Autowired
    private BResourceMapper bResourceMapper;
    public List<BResource> seletBRAll(String seek) {
        return bResourceMapper.selectBRAll(seek);
    }

    public BResource seletById(Integer id) {
        return bResourceMapper.seletById(id);
    }

    public int updateById(BResource bResource) {
        return bResourceMapper.updateById(bResource);
    }

    public int insertBR(Integer enable,String resourceName, String resourceUrl) {
        Map hashMap = new HashMap();
        hashMap.put("resourceName",resourceName);
        hashMap.put("resourceUrl",resourceUrl);
        hashMap.put("enable",enable);
        return bResourceMapper.insertBR(hashMap);
    }

    public int deletBR(Integer id) {
        return bResourceMapper.deletBR(id);
    }
}
