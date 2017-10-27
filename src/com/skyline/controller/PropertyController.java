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
import com.skyline.service.serviceInterface.PropertyPriceService;
import com.skyline.service.serviceInterface.PropertyService;
import com.skyline.service.serviceInterface.PropertyTypeService;


@Controller
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private PropertyTypeService propertyTypeService;

	@Autowired
	private PropertyPriceService propertyPriceService;
	
	
	@RequestMapping("property-list")
	public String listProperties(Model theModel){
		
		// get properties
		List<Property> theProperties = propertyService.getAll();
		
		theModel.addAttribute("properties", theProperties);
		
		return "property-list";
	}

	@GetMapping("property-detail")
	public String addProperty(Model theModel){
		
		Property theProperty = new Property();
		
		// get property types
		List<PropertyType> thePropertyTypes = propertyTypeService.getPropertyTypes();
				
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
			
			List<PropertyType> thePropertyTypes = propertyTypeService.getPropertyTypes();
			theModel.addAttribute("propertyTypes", thePropertyTypes);
			
			return"property-detail";
		}else{
	
			theProperty.setCurrentSpace(theProperty.getCapacity());
			
			theProperty.getPropertyPrice().setId(propertyPriceService.getIdOfNewOrExistingPrice(theProperty));
			
			propertyService.addProperty(theProperty);
			
			theModel.addAttribute("saved", true);
			
			return "property-detail";
		}
		
			
	}
	
	
	@GetMapping("UpdateProperty")
	public String updateProperty(@RequestParam("theId") int propertyId,
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
		
		return "property-detail";	
	} 

	@GetMapping("DeleteProperty")
	public String deleteProperty(@RequestParam("theId") int propertyId, 
			Model theModel){
		
		try{
		    propertyService.deleteProperty(propertyId);	
		}catch(EjbAccessException e){
			System.out.println("error" + e);
		}
		
		return "redirect:/property-list";
	}
	
	
}
