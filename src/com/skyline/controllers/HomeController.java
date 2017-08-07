package com.skyline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("dashboard")
	public String mainPage(){
		return "dashboard";
	}
	
	@RequestMapping("house")
	public String housesPage(){
		return "house_profiles";
	}
}
