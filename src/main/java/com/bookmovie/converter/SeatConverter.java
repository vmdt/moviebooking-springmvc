package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.SeatDTO;
import com.bookmovie.entity.SeatEntity;

@Component
public class SeatConverter {
	public SeatDTO toDTO(SeatEntity entity) {
		SeatDTO dto = new SeatDTO();
		dto.setId(entity.getId());
		dto.setMovieId(entity.getMovie().getId());
		dto.setShowTimingId(entity.getShowTiming().getId());
		dto.setPrice(entity.getPrice());
		dto.setSeatCode(entity.getSeatCode());
		dto.setStatus(entity.getStatus());
		return dto;
	}

	public SeatEntity toEntity(SeatDTO dto) {
		SeatEntity entity = new SeatEntity();
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setSeatCode(dto.getSeatCode());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
