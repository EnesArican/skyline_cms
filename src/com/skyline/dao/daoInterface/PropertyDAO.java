package com.skyline.dao.daoInterface;

import java.util.List;

import com.skyline.entity.Property;

public interface PropertyDAO{
	
	public List<Property> getProperties();
	
	public void saveProperty(Property property);
	
	public Property findProperty(int id);
	
	public void deleteProperty(int id);
	
	public Integer getNewSkyCode();
	

}
