package com.skyline.service.serviceInterface;

import java.util.List;

import com.skyline.entity.property.Booking;

public interface BookingService {

	public List<Booking> getBookings(int propertyId, int year, int studentId);
}
