package com.skyline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyline.entity.property.Property;
import com.skyline.entity.property.PropertyType;
import com.skyline.service.serviceInterface.PropertyService;
import com.skyline.service.serviceInterface.PropertyTypeService;


@Controller
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private PropertyTypeService propertyTypeService;

	@RequestMapping("property-list")
	public String listProperties(Model theModel){
		List<Property> theProperties = propertyService.getAll();
		theModel.addAttribute("properties", theProperties);
		return "property-list";
	}

	@GetMapping("property-detail")
	public String addProperty(Model theModel){
		Property theProperty = new Property();
		List<PropertyType> thePropertyTypes = propertyTypeService.getAll();
				
		// get new Sky Code
		if(theProperty.getSkyCode() == null){	
			theProperty.setSkyCode(propertyService.getNewSkyCode());
		}
		
		theModel.addAttribute("property",theProperty);
		theModel.addAttribute("propertyTypes", thePropertyTypes);			
		return("property-detail");
	}
	
	@PostMapping("saveProperty")
	public String saveProperty(
			@Valid @ModelAttribute("property") Property theProperty,
			BindingResult theBindingResult, Model theModel){
		
		if(theBindingResult.hasErrors()){			
			List<PropertyType> thePropertyTypes = propertyTypeService.getAll();
			theModel.addAttribute("propertyTypes", thePropertyTypes);		
			return"property-detail";
		}else{		
			propertyService.saveOrUpdate(theProperty);
			return "redirect:/displayProperty?theId=" + theProperty.getId() + "&saved=1";
		}		
	}
	
	// need to pass a parameter - boolean saved.
	@GetMapping("displayProperty")
	public String displayProperty(@RequestParam("theId") int propertyId, @RequestParam(value="saved", required=false) boolean saved,
			Model theModel){
			
		Property theProperty = propertyService.find(propertyId);
		List<PropertyType> thePropertyTypes = propertyTypeService.getAll();
				
		if(saved){
			theModel.addAttribute("saved", true); 
		}	
		
		theModel.addAttribute("property", theProperty);
		theModel.addAttribute("propertyTypes", thePropertyTypes);
		return "property-detail";	
	} 

	@GetMapping("DeleteProperty")
	public String deleteProperty(@RequestParam("theId") int propertyId, 
			Model theModel){
		
		try{
		    propertyService.remove(propertyId);	
		}catch(EjbAccessException e){
			System.out.println("error" + e);
		}	
		return "redirect:/property-list";
	}
	
}







