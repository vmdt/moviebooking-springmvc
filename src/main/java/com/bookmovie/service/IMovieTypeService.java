package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.MovieTypeDTO;

public interface IMovieTypeService {
	public List<MovieTypeDTO> findAll();
}
