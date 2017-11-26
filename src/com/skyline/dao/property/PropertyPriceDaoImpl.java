package com.skyline.dao.property;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.PropertyPriceDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.property.PropertyPrice;


@Repository
public class PropertyPriceDaoImpl extends GenericDaoImpl<PropertyPrice>
				implements PropertyPriceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public PropertyPrice findPropertyPrice(String price, String comission) {
		
		String query = "select P from PropertyPrice P where P.price = :price and P.comission = :comission";
		
		return getSession().createQuery(query, PropertyPrice.class)
										.setParameter("price", price)
										.setParameter("comission", comission)
										.uniqueResult();
	}


}
