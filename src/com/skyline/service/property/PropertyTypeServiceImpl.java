package com.skyline.service.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.dao.daoInterface.PropertyTypeDao;
import com.skyline.entity.property.PropertyType;
import com.skyline.service.generic.GenericServiceImpl;
import com.skyline.service.serviceInterface.PropertyTypeService;

@Service
public class PropertyTypeServiceImpl extends GenericServiceImpl<PropertyType>
		implements PropertyTypeService {

	
	private PropertyTypeDao propertyTypeDAO;
	
	public PropertyTypeServiceImpl(){}
	
	@Autowired
	public PropertyTypeServiceImpl(
			@Qualifier("propertyTypeDaoImpl") GenericDao<PropertyType> genericDao){
		super(genericDao);
		this.propertyTypeDAO = (PropertyTypeDao) genericDao;
	}
	
	
}
