package com.skyline.dao.property;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.PropertyDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.property.Property;


@Repository
public class PropertyDaoImpl extends GenericDaoImpl<Property> 
						implements PropertyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
		
	@Override
	public Integer getNewSkyCode() {
		String sql = "SELECT GetNewskyCode(); ";
		return (Integer) getSession().createNativeQuery(sql).uniqueResult();
	}
	
	



	
	
		
}







