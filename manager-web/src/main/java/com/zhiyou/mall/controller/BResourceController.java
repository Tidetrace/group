package com.zhiyou.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.mall.entity.BResource;
import com.zhiyou.mall.service.BResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Create by Tidetrace on 2017/11/9
 * desc:权限信息管理
 */
@Controller
@RequestMapping("/bResource")
public class BResourceController {
    @Autowired
    private BResourceService bResourceService;

    /**
     * desc: 权限信息模糊查询分页
     * return: 权限信息页面
     */
    @RequestMapping(value = "index", method = {RequestMethod.GET, RequestMethod.POST})
    public Object index(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                        String seek, Model model) {
        if ("".equals(seek)) {
            seek = null;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BResource> bResources = bResourceService.seletBRAll(seek);
        PageInfo<BResource> page = new PageInfo<BResource>(bResources);
        model.addAttribute("pageNum", page);
        model.addAttribute("bResources", bResources);
        for (BResource br : bResources) {
            System.out.println("权限名：" + br.getResourceName() + ":" + br.getResourceUrl());
        }
        return "basicInfo/resourceInfo";
    }

    /**
     * desc:根据id查询该条信息
     * return: 对应的结果集
     */
    @RequestMapping(value = "selectById/{id}", method = RequestMethod.GET)
    public Object seletById(@PathVariable Integer id, Model model) {
        BResource bResource = bResourceService.seletById(id);
        model.addAttribute("bResource", bResource);
        return "basicInfo/resource_settiing";
    }

    /**
     * desc:根据id进行修改
     * return: jsp页面 查询所有信息
     */
    @RequestMapping(value = "updateById.do", method = RequestMethod.POST)
    @ResponseBody
    public Object updateById(BResource bResource) {
        bResource.setUpdateTime(new Timestamp(new Date().getTime()));
        HashMap hashMap = new HashMap();
        int i = bResourceService.updateById(bResource);
        return i;
    }

    /**
     * desc:插入权限信息
     * return: 返回jsp页面再查询
     */
    @RequestMapping(value = "insertBR", method = RequestMethod.POST)
    @ResponseBody
    public Object insertBR(@RequestParam("enable") Integer enable, String resourceName, String resourceUrl) {
        int i = bResourceService.insertBR(enable, resourceName, resourceUrl);
        return i;
    }

    /**
     * desc:根据id进行删除
     * return: jsp页面，重新查询
     */
    @RequestMapping(value = "deletBR", method = RequestMethod.GET)
    @ResponseBody
    public Object insertBR(Integer id) {
        int i = bResourceService.deletBR(id);
        return i;
    }
}
