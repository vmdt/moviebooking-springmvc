package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.entity.MovieTypeEntity;

@Component
public class MovieTypeConverter {
	
	public MovieTypeDTO toDTO(MovieTypeEntity entity) {
		MovieTypeDTO dto = new MovieTypeDTO();
		dto.setId(entity.getId());
		dto.setTypeName(entity.getTypeName());
		return dto;
	}

	public MovieTypeEntity toEntity(MovieTypeDTO dto) {
		MovieTypeEntity entity = new MovieTypeEntity();
		entity.setId(dto.getId());
		entity.setTypeName(dto.getTypeName());
		return entity;
	}
	

}
