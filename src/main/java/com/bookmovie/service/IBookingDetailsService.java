package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.BookingDetailsDTO;

public interface IBookingDetailsService {
	public BookingDetailsDTO save(BookingDetailsDTO model);
	public List<BookingDetailsDTO> findAllByBookingId(Long bookingId);
	public void deleteByBookingIdAndSeatId(Long bid, Long sid);
}
