package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.BookingDTO;
import com.bookmovie.entity.BookingEntity;

@Component
public class BookingConverter {
	public BookingDTO toDTO(BookingEntity entity) {
		BookingDTO dto = new BookingDTO();
		dto.setId(entity.getId());
		dto.setUserId(entity.getUser().getId());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setStatus(entity.getStatus());
		return dto;
	}

	public BookingEntity toEntity(BookingDTO dto) {
		BookingEntity entity = new BookingEntity();
		entity.setId(dto.getId());
		entity.setTotalPrice(dto.getTotalPrice());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
