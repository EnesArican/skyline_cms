package com.skyline.dao.property;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.PropertyPriceDao;
import com.skyline.entity.PropertyPrice;


@Repository
public class PropertyPriceDaoImpl implements PropertyPriceDao {

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


	
	@Override
	public void savePropertyPrice(PropertyPrice propertyPrice) {
		getSession().save(propertyPrice);
	}

}
