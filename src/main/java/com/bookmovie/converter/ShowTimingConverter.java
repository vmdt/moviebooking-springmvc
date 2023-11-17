package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.ShowTimingDTO;
import com.bookmovie.entity.ShowTimingEntity;

@Component
public class ShowTimingConverter {
	public ShowTimingDTO toDTO(ShowTimingEntity entity) {
		ShowTimingDTO dto = new ShowTimingDTO();
		dto.setId(entity.getId());
		dto.setTime(entity.getTime());
		return dto;
	}

	public ShowTimingEntity toEntity(ShowTimingDTO dto) {
		ShowTimingEntity entity = new ShowTimingEntity();
		entity.setId(dto.getId());
		entity.setTime(dto.getTime());
		return entity;
	}
}
