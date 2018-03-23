package com.skyline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.skyline.entity.property.Booking;
import com.skyline.service.serviceInterface.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
		
	@GetMapping("GetBookedDates")     
	@ResponseBody
	public String GetBookings(@RequestParam("propertyId") int propertyId, @RequestParam("selectedYear") int year, 
			@RequestParam("studentId") int studentId){
		
		List<Booking> bookings = bookingService.getBookings(propertyId, year, studentId);
		String json = new Gson().toJson(bookings);
		return json;
	}
}
