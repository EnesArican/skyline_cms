package com.skyline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.entity.PropertyType;


@Repository
public class PropertyTypeDAOImpl implements PropertyTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	
	@Override
	public List<PropertyType> getPropertyTypes() {
		return getSession().
				  createQuery("from PropertyType", PropertyType.class).getResultList();
	}

	
	@Override
	public PropertyType findPropertyType(int id) {
		return getSession().find( PropertyType.class, id );
	}	


	













}







