package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.NationDTO;

public interface INationService {
	public List<NationDTO> findAll();
}
