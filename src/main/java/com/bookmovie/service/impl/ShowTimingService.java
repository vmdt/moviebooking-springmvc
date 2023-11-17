package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.ShowTimingConverter;
import com.bookmovie.dto.ShowTimingDTO;
import com.bookmovie.entity.ShowTimingEntity;
import com.bookmovie.repository.ShowTimingRepository;
import com.bookmovie.service.IShowTimingService;

@Service
public class ShowTimingService implements IShowTimingService {
	
	@Autowired
	private ShowTimingRepository showTimingRepo;
	
	@Autowired
	private ShowTimingConverter showTimingConverter;
	
	@Override
	public List<ShowTimingDTO> findAll() {
		List<ShowTimingDTO> models = new ArrayList<ShowTimingDTO>();
		List<ShowTimingEntity> times = showTimingRepo.findAll();
		for (ShowTimingEntity time : times) {
			ShowTimingDTO model = showTimingConverter.toDTO(time);
			models.add(model);
		}
		
		return models;
	}

	@Override
	public ShowTimingDTO findById(Long id) {
		ShowTimingEntity entity = showTimingRepo.findOne(id);
		return showTimingConverter.toDTO(entity);
	}
	
}
