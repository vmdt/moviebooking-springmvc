package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.FeedbackDTO;
import com.bookmovie.entity.FeedbackEntity;

@Component
public class FeedbackConverter {
	public FeedbackDTO toDTO(FeedbackEntity entity) {
		FeedbackDTO dto = new FeedbackDTO();
		dto.setUserId(entity.getUser().getId());
		dto.setMovieId(entity.getMovie().getId());
		dto.setContent(entity.getContent());
		dto.setCreateAt(entity.getCreateAt());
		dto.setFullname(entity.getUser().getFullname());
		return dto;
	}

	public FeedbackEntity toEntity(FeedbackDTO dto) {
		FeedbackEntity entity = new FeedbackEntity();
		entity.setContent(dto.getContent());
		entity.setCreateAt(dto.getCreateAt());
		return entity;
	}
}
