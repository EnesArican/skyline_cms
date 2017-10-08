package com.skyline.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.entity.Property;


@Repository
public class PropertyDAOImpl implements PropertyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	

	@Override
	public List<Property> getProperties() {
		 return getSession().
				  createQuery("from Property", Property.class).getResultList();
	}

	@Override
	public void saveProperty(Property property) {
		getSession().saveOrUpdate(property);
		
	}

	@Override
	public Property findProperty(int id) {
		return getSession().find( Property.class, id );
	}
		
	@Override
	public BigInteger getNewSkyCode() {
		String sql = "SELECT t1.sky_code+1 AS Missing "
				+ "FROM property AS t1 LEFT JOIN property "
				+ "AS t2 ON t1.sky_code+1 = t2.sky_code "
				+ "WHERE t2.sky_code IS NULL ORDER BY "
				+ "t1.sky_code LIMIT 1; ";
		
		return (BigInteger) getSession().createNativeQuery(sql).uniqueResult();
	}



	
	@Override
	public void deleteProperty(int id) {
		// delete object with primary key
		Query<?> theQuery = getSession().createQuery("delete from Property where id=:propertyId");
				
		theQuery.setParameter("propertyId", id);
				
		theQuery.executeUpdate();
				
		
	}
		
}







