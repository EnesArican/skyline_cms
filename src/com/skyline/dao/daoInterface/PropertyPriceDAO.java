package com.skyline.dao.daoInterface;

import com.skyline.entity.PropertyPrice;

public interface PropertyPriceDao{
	
	
	public PropertyPrice findPropertyPrice(String price, String comission);
	
	public void savePropertyPrice(PropertyPrice propertyPrice);
}
