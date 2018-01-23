package com.skyline.dao.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.BookingDao;
import com.skyline.entity.property.Booking;

@Repository
public class BookingDaoImpl implements BookingDao { //extends GenericDaoImpl<StudentAccomodation> implements BookingDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Booking> getBookings(int propertyId, int year, int studentId) {
			
	Query query  = getSession().createNativeQuery("CALL Property_Get_Bookings(:propertyID, :year, :studentID)")
				.setParameter("propertyID", propertyId)
				.setParameter("year", year)
				.setParameter("studentID", studentId);
	
		
	List<Object> result = (List<Object>) query.list();
	List<Booking> items = new ArrayList<Booking>();
	
	Iterator itr = result.iterator();
	
	while(itr.hasNext()){	
		Booking item = new Booking();
		
		Object[] b = (Object[]) itr.next();
		
		item.setStartDate((Date)b[0]);
		item.setEndDate((Date)b[1]);
		item.setNumberOfStudents((Integer)b[2]);
		items.add(item);
	}
	return items;
	}
	
	
}
