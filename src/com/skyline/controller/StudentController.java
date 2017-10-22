package com.skyline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("student-list")
	public String listProperties(Model theModel){
		
		// get properties
		//List<Property> theProperties = propertyService.getProperties();
		
		//theModel.addAttribute("properties", theProperties);
		
		return "student-list";
	}
	
}
