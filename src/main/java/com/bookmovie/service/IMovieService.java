package com.bookmovie.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bookmovie.dto.MovieDTO;

public interface IMovieService {
	public List<MovieDTO> searchMovie(String keyword);
	public List<MovieDTO> findAll(Pageable pageable);
	public List<MovieDTO> findAllByTypeId(Long typeId, Pageable pageable);
	public List<MovieDTO> findAllByNationId(Long nationId, Pageable pageable);
	public List<MovieDTO> findAllByTypeIdAndNationId(Long typeId, Long nationId, Pageable pageable);
	public MovieDTO save(MovieDTO model);
	public MovieDTO findById(Long id);
	public void delete(Long id);
	public int getTotalItem();
	public int getTotalItemByTypeId(Long typeId);
	public int getTotalItemByNationId(Long nationId);
	public int getTotalItemByTypeIdAndNationId(Long typeId, Long nationId);
}
