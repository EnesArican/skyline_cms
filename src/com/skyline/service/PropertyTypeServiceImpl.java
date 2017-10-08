package com.skyline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.PropertyTypeDAO;
import com.skyline.entity.PropertyType;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

	@Autowired
	private PropertyTypeDAO propertyTypeDAO;
	
	
	@Override
	@Transactional
	public List<PropertyType> getPropertyTypes() {		
		  return propertyTypeDAO.getPropertyTypes();
	}

	@Override
	@Transactional
	public PropertyType findOne(int id) {
		return propertyTypeDAO.findPropertyType(id);
	}

}
