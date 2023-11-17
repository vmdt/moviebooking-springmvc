package com.bookmovie.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookmovie.dto.BookingDTO;
import com.bookmovie.dto.BookingDetailsDTO;
import com.bookmovie.dto.SeatDTO;
import com.bookmovie.service.IBookingDetailsService;
import com.bookmovie.service.IBookingService;
import com.bookmovie.service.ISeatService;

@RestController
public class BookingAPI {
	@Autowired
	private IBookingService bookingService;
	
	@Autowired 
	private IBookingDetailsService bookingDetailsService;
	
	@Autowired
	private ISeatService seatService;
	
	@RequestMapping(value = "/api/bookings", method = RequestMethod.POST, consumes = {"*/*"})
	public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
		bookingDTO.setStatus("unpaid");
		BookingDTO newBooking = bookingService.save(bookingDTO);
		for (Long seatId : bookingDTO.getSeatIds()) {
			if (seatId != null) {
				BookingDetailsDTO BD = new BookingDetailsDTO();
				BD.setBookingId(newBooking.getId());
				BD.setSeatId(seatId);
				String datenow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				BD.setBookingTime(datenow);
				bookingDetailsService.save(BD);
			}
		}
		
		return newBooking;
	}
	
	@RequestMapping(value = "/api/bookings/{id}", method = RequestMethod.DELETE, consumes = {"*/*"})
	public void deleteBooking(@PathVariable("id") Long id) {
		bookingService.deleteById(id);
	}
	
	@RequestMapping(value = "/api/bookings", method = RequestMethod.PUT, consumes = {"*/*"})
	public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO) {
		if (bookingDTO.getStatus().equals("paid")) {
			List<BookingDetailsDTO> BDList = bookingDetailsService.findAllByBookingId(bookingDTO.getId());
			for (BookingDetailsDTO BD : BDList) {
				SeatDTO seat = new SeatDTO();
				seat.setId(BD.getSeatId());
				seat.setStatus("booked");
				seatService.save(seat);
			}
		}
		return bookingService.save(bookingDTO);
	}
}
