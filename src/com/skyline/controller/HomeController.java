package com.skyline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("dashboard")
	public String mainPage(){
		return "dashboard";
	}
	
	@RequestMapping("allStudents")
	public String allStudents(){
		return "all_students";
	}
	
	
}
