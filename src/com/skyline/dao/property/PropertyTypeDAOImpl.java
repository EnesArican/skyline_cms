package com.skyline.dao.property;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.PropertyTypeDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.property.PropertyType;


@Repository
public class PropertyTypeDaoImpl extends GenericDaoImpl<PropertyType> 
					implements PropertyTypeDao {

	@Autowired
	private SessionFactory sessionFactory;
		
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
}







