package com.skyline.service.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.PropertyDAO;
import com.skyline.entity.Property;
import com.skyline.service.serviceInterface.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService{

	



	@Autowired
	private PropertyDAO propertyDAO;
	
	@Override
	@Transactional
	public List<Property> getProperties() {		
		  return propertyDAO.getProperties();
	}

	@Override
	@Transactional
	public void addProperty(Property theProperty) {
		propertyDAO.saveProperty(theProperty);
	}
	
	@Override
	@Transactional
	public Integer getNewSkyCode() {
		return propertyDAO.getNewSkyCode().intValue();
	}

	@Override
	@Transactional
	public Property findProperty(int id) {
		return propertyDAO.findProperty(id);
	}

	@Override
	@Transactional
	public void deleteProperty(int id) {
		propertyDAO.deleteProperty(id);
	}

	
}
