package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GoodsController {

	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}

}