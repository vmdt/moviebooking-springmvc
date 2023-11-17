package com.bookmovie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmovie.dto.BookingDetailsDTO;
import com.bookmovie.service.IBookingDetailsService;

@RestController
public class BookingDetailsAPI {
	
	@Autowired
	private IBookingDetailsService bookingDetailsService;
	  
	@RequestMapping(value = "/api/booking-details", method = RequestMethod.POST, consumes = {"*/*"})
	public BookingDetailsDTO createBookingDetails(@RequestBody BookingDetailsDTO model) {
		return bookingDetailsService.save(model);
	}
	
	@RequestMapping(value = "/api/booking-details", method = RequestMethod.PUT, consumes = {"*/*"})
	public BookingDetailsDTO updateBookingDetails(@RequestBody BookingDetailsDTO model) {	
		return bookingDetailsService.save(model);
	}
	
	@RequestMapping(value = "/api/booking-details", method = RequestMethod.GET, consumes = {"*/*"})
	public List<BookingDetailsDTO> getBookingDetailsByBid(@RequestParam(value = "bookingId") Long bookingId) {
		List<BookingDetailsDTO> models = bookingDetailsService.findAllByBookingId(bookingId);
		return models;
	}
	
	@RequestMapping(value = "/api/booking-details", method = RequestMethod.DELETE, consumes = {"*/*"})
	public void deleteBookingDetails(@RequestParam(value = "bookingId") Long bookingId, @RequestParam(value = "seatId") Long seatId) {
		bookingDetailsService.deleteByBookingIdAndSeatId(bookingId, seatId);
	}
}
