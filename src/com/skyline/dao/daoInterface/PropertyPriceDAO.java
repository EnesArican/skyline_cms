package com.skyline.dao.daoInterface;

import com.skyline.entity.property.PropertyPrice;

public interface PropertyPriceDao extends GenericDao <PropertyPrice> {
	
	public PropertyPrice findPropertyPrice(String price, String comission);
	
}
