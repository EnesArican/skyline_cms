package com.skyline.service;

import java.util.List;

import com.skyline.entity.PropertyType;


public interface PropertyTypeService {

	
	public List<PropertyType> getPropertyTypes();
	
	public PropertyType findOne(int id);
	
}
