package com.skyline.service.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.dao.daoInterface.PropertyDao;
import com.skyline.entity.property.Property;
import com.skyline.service.generic.GenericServiceImpl;
import com.skyline.service.serviceInterface.PropertyService;

@Service
public class PropertyServiceImpl extends GenericServiceImpl<Property>
		implements PropertyService{

	
	private PropertyDao propertyDAO;
	
	public PropertyServiceImpl(){}
	
	@Autowired
	public PropertyServiceImpl(
			@Qualifier("propertyDaoImpl") GenericDao<Property> genericDao){
		super(genericDao);
		this.propertyDAO = (PropertyDao) genericDao;
	}
	
	
	
	
	@Override
	@Transactional
	public Integer getNewSkyCode() {
		return propertyDAO.getNewSkyCode().intValue();
	}

}
