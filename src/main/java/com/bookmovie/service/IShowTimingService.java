package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.ShowTimingDTO;

public interface IShowTimingService {
	List<ShowTimingDTO> findAll(); 
	ShowTimingDTO findById(Long id);
}
