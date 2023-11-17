package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.NationDTO;
import com.bookmovie.entity.NationEntity;

@Component
public class NationConverter {
	
	public NationDTO toDTO(NationEntity entity) {
		NationDTO dto = new NationDTO();
		dto.setId(entity.getId());
		dto.setNationName(entity.getNationName());
		return dto;
	}

	public NationEntity toEntity(NationDTO dto) {
		NationEntity entity = new NationEntity();
		entity.setId(dto.getId());
		entity.setNationName(dto.getNationName());
		return entity;
	}
	
}
