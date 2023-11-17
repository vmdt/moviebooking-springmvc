package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.BookingDTO;

public interface IBookingService {
	public BookingDTO findById(Long id);
	public BookingDTO save(BookingDTO model);
	public void deleteById(Long id);
	public List<BookingDTO> findAllByUserId(Long userId);
}
