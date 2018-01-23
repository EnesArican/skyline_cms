package com.skyline.service.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.BookingDao;
import com.skyline.entity.property.Booking;
import com.skyline.service.serviceInterface.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	public BookingServiceImpl(){}
	
	@Override
	@Transactional
	public List<Booking> getBookings(int propertyId, int year, int studentId) {
		return bookingDao.getBookings(propertyId, year, studentId);
	}
		
}



