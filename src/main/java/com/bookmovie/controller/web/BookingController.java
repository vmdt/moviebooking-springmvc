package com.bookmovie.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.BookingDTO;
import com.bookmovie.dto.BookingDetailsDTO;
import com.bookmovie.service.IBookingDetailsService;
import com.bookmovie.service.IBookingService;

@Controller
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private IBookingDetailsService bookingDetailsService;
	
	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.GET)
	public ModelAndView renderPayment(@PathVariable(value="id") Long bookingId, @RequestParam(value="status") String status) {
		BookingDTO booking = bookingService.findById(bookingId);
		List<BookingDetailsDTO> bookList = bookingDetailsService.findAllByBookingId(bookingId);
		
		ModelAndView mav = new ModelAndView("/web/payment");
		mav.addObject("booking", booking);
		mav.addObject("bookList", bookList);
		return mav;
	}
	
}
