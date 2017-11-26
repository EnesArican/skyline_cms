package com.skyline.service.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.PropertyPriceDao;
import com.skyline.entity.property.Property;
import com.skyline.entity.property.PropertyPrice;
import com.skyline.service.serviceInterface.PropertyPriceService;

@Service
public class PropertyPriceServiceImpl implements PropertyPriceService {

	@Autowired
	private PropertyPriceDao propertyPriceDao;
	
	
	
	@Override
	@Transactional
	public Integer getIdOfNewOrExistingPrice(Property theProperty) {
		
		PropertyPrice thePrice = theProperty.getPropertyPrice();
		
		String price = thePrice.getPrice();
		String comission = thePrice.getComission();
		
			
		thePrice = propertyPriceDao.findPropertyPrice(price, comission);
			
		
		
		if(thePrice == null){
			// no such price row. saving as new
			
			propertyPriceDao.saveOrUpdate(theProperty.getPropertyPrice());
			
			thePrice = propertyPriceDao.findPropertyPrice(price, comission);
			
			return thePrice.getId();
			
			
		}else{			
			// price entity already exists
			
			return thePrice.getId();
			
		}

	}

}








