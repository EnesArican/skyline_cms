package com.skyline.service.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.PropertyTypeDao;
import com.skyline.entity.PropertyType;
import com.skyline.service.serviceInterface.PropertyTypeService;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

	@Autowired
	private PropertyTypeDao propertyTypeDAO;
	
	
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
