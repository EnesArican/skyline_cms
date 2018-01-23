package com.skyline.dao.daoInterface;

import java.util.List;

import com.skyline.entity.property.Booking;

public interface BookingDao {//extends GenericDao <StudentAccomodation> {

	public List<Booking> getBookings(int propertyId, int year, int studentId);
	
}
