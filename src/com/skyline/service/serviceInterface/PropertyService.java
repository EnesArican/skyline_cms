package com.skyline.service.serviceInterface;

import java.util.List;

import com.skyline.entity.Property;


public interface PropertyService{

	
	public List<Property> getProperties();
	
	public void addProperty(Property theProperty);
	
	public Property findProperty(int id);
	
	public Integer getNewSkyCode();
	
	public void deleteProperty(int id);
	
}
