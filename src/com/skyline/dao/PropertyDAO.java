package com.skyline.dao;

import java.math.BigInteger;
import java.util.List;

import com.skyline.entity.Property;

public interface PropertyDAO{
	
	public List<Property> getProperties();
	
	public void saveProperty(Property property);
	
	public Property findProperty(int id);
	
	public void deleteProperty(int id);
	
	public BigInteger getNewSkyCode();
	

}
