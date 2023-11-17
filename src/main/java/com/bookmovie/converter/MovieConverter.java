package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.MovieDTO;
import com.bookmovie.entity.MovieEntity;

@Component
public class MovieConverter {
	public MovieDTO toDTO(MovieEntity entity) {
		MovieDTO result = new MovieDTO();
		result.setId(entity.getId());
		result.setMovieName(entity.getMovieName());
		result.setDuration(entity.getDuration());
		result.setThumbnail(entity.getThumbnail());
		result.setDescription(entity.getDescription());
		result.setLanguage(entity.getLanguage());
		result.setDirectors(entity.getDirectors());
		result.setActors(entity.getActors());
		result.setTypeId(entity.getType().getId());
		result.setTypeName(entity.getType().getTypeName());
		result.setNationId(entity.getNation().getId());
		result.setNationName(entity.getNation().getNationName());
		return result;
	}
	
	public MovieEntity toEntity(MovieDTO dto) {
		MovieEntity result = new MovieEntity();
		result.setId(dto.getId());
		result.setMovieName(dto.getMovieName());
		result.setDuration(dto.getDuration());
		result.setThumbnail(dto.getThumbnail());
		result.setDescription(dto.getDescription());
		result.setLanguage(dto.getLanguage());
		result.setDirectors(dto.getDirectors());
		result.setActors(dto.getActors());
//		MovieTypeEntity type = new MovieTypeEntity();
//		type.setId(dto.getTypeId());
//		type.setTypeName(dto.getTypeName());
//		result.setType(type);
//		NationEntity nation = new NationEntity();
//		nation.setId(dto.getNationId());
//		nation.setNationName(dto.getNationName());
//		result.setNation(nation);
		return result;
	}
}
