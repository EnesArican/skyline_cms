package com.skyline.dao;

import java.util.List;

import com.skyline.entity.PropertyType;

public interface PropertyTypeDAO{
	
	public List<PropertyType> getPropertyTypes();
	
	public PropertyType findPropertyType(int id);
	
	
}
