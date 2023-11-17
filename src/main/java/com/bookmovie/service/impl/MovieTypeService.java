package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.MovieTypeConverter;
import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.entity.MovieTypeEntity;
import com.bookmovie.repository.MovieTypeRepository;
import com.bookmovie.service.IMovieTypeService;



@Service
public class MovieTypeService implements IMovieTypeService {
	
	@Autowired
	private MovieTypeRepository movieTypeRepo;
	
	@Autowired 
	private MovieTypeConverter movieTypeConverter;

	@Override
	public List<MovieTypeDTO> findAll() {
		List<MovieTypeDTO> models = new ArrayList<MovieTypeDTO>();
		List<MovieTypeEntity> movieTypes = movieTypeRepo.findAll();
		for (MovieTypeEntity movieType : movieTypes) {
			MovieTypeDTO model = movieTypeConverter.toDTO(movieType);
			models.add(model);
		}
		return  models;
	}
	
}
