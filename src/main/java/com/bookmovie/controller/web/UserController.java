package com.bookmovie.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.BookingDTO;
import com.bookmovie.dto.UserDTO;
import com.bookmovie.service.IBookingService;
import com.bookmovie.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBookingService bookingService;
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public ModelAndView userPage(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("/web/user-infor");
		UserDTO user = userService.findById(id);
		List<BookingDTO> bookings = bookingService.findAllByUserId(id);
		
		mav.addObject("user", user);
		mav.addObject("bookings", bookings);
		return mav;
	}
}
