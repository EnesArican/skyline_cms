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

import com.skyline.entity.Property;
import com.skyline.entity.PropertyType;
import com.skyline.service.PropertyPriceService;
import com.skyline.service.PropertyService;
import com.skyline.service.PropertyTypeService;


@Controller
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private PropertyTypeService propertyTypeService;

	@Autowired
	private PropertyPriceService propertyPriceService;
	
	
	@RequestMapping("house")
	public String listProperties(Model theModel){
		
		// get properties
		List<Property> theProperties = propertyService.getProperties();
		
		// add properties to the model
		theModel.addAttribute("properties", theProperties);
		
		
		return "house_profiles";
	}

	@GetMapping("formAddProperty")
	public String formAddProperty(Model theModel){
		
		Property theProperty = new Property();
		
		// get property types
		List<PropertyType> thePropertyTypes = propertyTypeService.getPropertyTypes();
				
		// get new Sky Code
		theModel.addAttribute("skyCode",propertyService.getNewSkyCode());
		
		theModel.addAttribute("property",theProperty);
		theModel.addAttribute("propertyTypes", thePropertyTypes);
					
		return("house_profiles-form");
	}
	
	@PostMapping("saveProperty")
	//@ResponseBody
	public String saveProperty(
			@Valid @ModelAttribute("property") Property theProperty,
			BindingResult theBindingResult, Model theModel){
		
		if(theBindingResult.hasErrors()){
			
			List<PropertyType> thePropertyTypes = propertyTypeService.getPropertyTypes();
			theModel.addAttribute("propertyTypes", thePropertyTypes);
			theModel.addAttribute("skyCode",propertyService.getNewSkyCode());
			
			
			return"house_profiles-form";
		}else{
			theProperty.setCurrentSpace(theProperty.getCapacity());
			theProperty.setSkyCode(propertyService.getNewSkyCode());
			
			theProperty.getPropertyPrice().setId(propertyPriceService.getIdOfNewOrExistingPrice(theProperty));
			
			
			
			propertyService.addProperty(theProperty);
			
			// do stuff to show property saved pop-up
			Property freshProperty = new Property();
			
			theModel.addAttribute("property",freshProperty);	
			theModel.addAttribute("saved", true);
			
			return "house_profiles-form";
		}
		
			
	}
	
	// still working on it
	@GetMapping("formUpdateProperty")
	public String formUpdateProperty(@RequestParam("theId") int propertyId,
			Model theModel){
		
	
		Property theProperty = propertyService.findProperty(propertyId);
		List<PropertyType> thePropertyTypes = propertyTypeService.getPropertyTypes();
				
		// fix number format of prices
		String theComission = theProperty.getPropertyPrice().getComission();
		theComission = theComission.substring(0, theComission.length()- 3);	
		theProperty.getPropertyPrice().setComission(theComission);
		
		String thePrice = theProperty.getPropertyPrice().getPrice();
		thePrice = thePrice.substring(0, thePrice.length() - 3);
		theProperty.getPropertyPrice().setPrice(thePrice);
		
		
		theModel.addAttribute("property", theProperty);
		theModel.addAttribute("propertyTypes", thePropertyTypes);
		
		// get the Sky Code
		theModel.addAttribute("skyCode", theProperty.getSkyCode());
		
		
		return "house_profiles-form";	
	} 

	@GetMapping("formDeleteProperty")
	public String formDeleteProperty(@RequestParam("theId") int propertyId, 
			Model theModel){
		
		try{
		    propertyService.deleteProperty(propertyId);	
		}catch(EjbAccessException e){
			System.out.println("error" + e);
		}
		
		theModel.addAttribute("deleted", true);
		
		return "redirect:/house";
	}
	
	
}
