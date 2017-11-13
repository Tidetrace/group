package com.zhiyou.mall.api.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home")
public class ApiController {
	@RequestMapping("/index")
	public Object goodsCat(){


		return "index";
	}

}
