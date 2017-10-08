package com.skyline.dao;

import com.skyline.entity.PropertyPrice;

public interface PropertyPriceDAO{
	
	
	public PropertyPrice findPropertyPrice(String price, String comission);
	
	public void savePropertyPrice(PropertyPrice propertyPrice);
}
