package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.BookingDetailsDTO;
import com.bookmovie.entity.BookingDetailsEntity;

@Component
public class BookingDetailsConverter {
	public BookingDetailsDTO toDTO(BookingDetailsEntity entity) {
		BookingDetailsDTO dto = new BookingDetailsDTO();
		dto.setBookingId(entity.getBooking().getId());
		dto.setSeatId(entity.getSeat().getId());
		dto.setSeatCode(entity.getSeat().getSeatCode());
		dto.setPrice(entity.getSeat().getPrice());
		dto.setBookingTime(entity.getBookingTime());
		return dto;
	}

	public BookingDetailsEntity toEntity(BookingDetailsDTO dto) {
		BookingDetailsEntity entity = new BookingDetailsEntity();
		entity.setBookingTime(dto.getBookingTime());
		return entity;
	}
}
