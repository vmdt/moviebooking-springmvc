package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.NationConverter;
import com.bookmovie.dto.NationDTO;
import com.bookmovie.entity.NationEntity;
import com.bookmovie.repository.NationRepository;
import com.bookmovie.service.INationService;

@Service
public class NationService implements INationService {
	@Autowired
	private NationRepository nationRepo;
	
	@Autowired 
	private NationConverter nationConverter;

	@Override
	public List<NationDTO> findAll() {
		List<NationDTO> models = new ArrayList<NationDTO>();
		List<NationEntity> nations = nationRepo.findAll();
		for (NationEntity nation : nations) {
			NationDTO model = nationConverter.toDTO(nation);
			models.add(model);
		}
		return models;
	}
}
