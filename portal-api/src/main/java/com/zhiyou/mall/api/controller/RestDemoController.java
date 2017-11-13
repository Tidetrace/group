package com.zhiyou.mall.api.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class RestDemoController {

	@RequestMapping(value = "/demo",method = RequestMethod.POST)
	public Object add(String name){
		System.out.println("add:"+name);

		HashMap result = new HashMap();
		result.put("success",true);

		return result;
	}

	@RequestMapping(value = "/demo/${id}",method = RequestMethod.DELETE)
	public Object delete(@PathVariable int id){
		System.out.println("delete:"+id);

		HashMap result = new HashMap();
		result.put("success",true);

		return result;
	}

	@RequestMapping(value = "/demo/{id}",method = RequestMethod.PUT)
	public Object update(@PathVariable int id, String name){

		System.out.println("update:"+id+"-"+name);
		HashMap result = new HashMap();
		result.put("success",true);

		return result;
	}

	@RequestMapping(value = "/demo/{id}",method = RequestMethod.GET)
	public Object query(@PathVariable int id){

		System.out.println("get:"+id);

		Map m1 = new HashMap();
		m1.put("id",id);
		m1.put("name",id+"aaaaname");

		return m1;
	}

	@RequestMapping(value = "/demos",method = RequestMethod.GET)
	public Object all(HttpServletResponse response){

		//解决跨域问题的一种方案，就是设置response的header信息
		response.setHeader("Access-Control-Allow-Origin","*");
//		response.setHeader("Access-Control-Allow-Methods","POST");

		System.out.println("get all");

		List list = demosList();

		return list;
	}

	@RequestMapping(value = "/jsonpScript",method = RequestMethod.GET)
	public Object jsonp1(HttpServletRequest request,HttpServletResponse response){

		System.out.println("script");
		try {
			int s = 30;
			response.getWriter().write("var i=10;alert(i+"+s+");");
		}catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}


	@RequestMapping(value = "/jsonp",method = RequestMethod.GET)
	public Object jsonp(HttpServletRequest request,HttpServletResponse response){

		System.out.println("jsonp");
		String callback = request.getParameter("callback");

		List list = demosList();

		//两种方法
		//1，写回响应数据，使用alibaba的fastjson生成字符串
		/*try {
			//  getresult('aaaaaaaa')
			response.getWriter().write(callback + "(" + JSON.toJSONString(list) + ")");
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}*/

		//二种,使用jackson中提供的JSONPObject对象
		JSONPObject j=  new JSONPObject(callback,list);
		return j;
	}

	/**
	 * Created by zhouyanchao on 2017/11/8
	 * Descr:模拟数据
	 *
	 */
	public List<Map> demosList(){
		List<Map> list = new ArrayList<Map>();
		Map m1 = new HashMap();
		m1.put("id",1);
		m1.put("name","1111");
		list.add(m1);

		Map m2 = new HashMap();
		m2.put("id",2);
		m2.put("name","2222");
		list.add(m1);

		Map m3 = new HashMap();
		m3.put("id",3);
		m3.put("name","3333");
		list.add(m1);

		Map m4 = new HashMap();
		m4.put("id",4);
		m4.put("name","4444");
		list.add(m4);

		return list;
	}

}
