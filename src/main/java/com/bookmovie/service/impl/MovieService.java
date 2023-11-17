package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.MovieConverter;
import com.bookmovie.dto.MovieDTO;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.repository.MovieRepository;
import com.bookmovie.repository.MovieTypeRepository;
import com.bookmovie.repository.NationRepository;
import com.bookmovie.service.IMovieService;

@Service
public class MovieService implements IMovieService {
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private MovieTypeRepository movieTypeRepo;
	
	@Autowired
	private NationRepository nationRepo;
	
	@Autowired
	private MovieConverter movieConverter;
	
	@Override
	public List<MovieDTO> findAll(Pageable pageable) {
		List<MovieDTO> models = new ArrayList<MovieDTO>();
		List<MovieEntity> movies = movieRepo.findAll(pageable).getContent();
		for (MovieEntity movie : movies) {
			MovieDTO model = movieConverter.toDTO(movie);
			models.add(model);
		}
		return models;
	}
	
	@Override
	@Transactional
	public MovieDTO save(MovieDTO model) {
		MovieEntity newMovie = new MovieEntity();
		
		if (model.getId() != null) {
			MovieEntity oldMovie = movieRepo.findOne(model.getId());
			if (model.getMovieName() != null)
				oldMovie.setMovieName(model.getMovieName());
			if (model.getDescription() != null)
				oldMovie.setDescription(model.getDescription());
			if (model.getThumbnail() != null)
				oldMovie.setThumbnail(model.getThumbnail());
			if (model.getDirectors() != null)
				oldMovie.setDirectors(model.getDirectors());
			if (model.getActors() != null)
				oldMovie.setActors(model.getActors());
			if (model.getLanguage() != null)
				oldMovie.setLanguage(model.getLanguage());
			if (model.getTypeId() != null)	
				oldMovie.setType(movieTypeRepo.findOne(model.getTypeId()));
			if (model.getNationId() != null)
				oldMovie.setNation(nationRepo.findOne(model.getNationId()));
			oldMovie.setDuration(model.getDuration());
			return movieConverter.toDTO(movieRepo.save(oldMovie));
		} else {
			newMovie = new MovieConverter().toEntity(model);
			if (model.getTypeId() != null)	
				newMovie.setType(movieTypeRepo.findOne(model.getTypeId()));
			if (model.getNationId() != null)
				newMovie.setNation(nationRepo.findOne(model.getNationId()));
		}
		
		return movieConverter.toDTO(movieRepo.save(newMovie));
	}

	@Override
	public List<MovieDTO> findAllByTypeId(Long typeId, Pageable pageable) {
		List<MovieDTO> models = new ArrayList<MovieDTO>();
		List<MovieEntity> movies = movieRepo.findAllByTypeId(typeId, pageable);
		for (MovieEntity movie : movies) {
			MovieDTO model = new MovieConverter().toDTO(movie);
			models.add(model);
		}
		return models;
	}

	@Override
	public MovieDTO findById(Long id) {
		MovieEntity movie = movieRepo.findOne(id);
		return movieConverter.toDTO(movie);
	}

	@Override
	public void delete(Long id) {
		movieRepo.delete(id);
	}

	@Override
	public List<MovieDTO> findAllByNationId(Long nationId, Pageable pageable) {
		List<MovieDTO> models = new ArrayList<MovieDTO>();
		List<MovieEntity> movies = movieRepo.findAllByNationId(nationId, pageable);
		for (MovieEntity movie : movies) {
			MovieDTO model = new MovieConverter().toDTO(movie);
			models.add(model);
		}
		return models;
	}

	@Override
	public List<MovieDTO> findAllByTypeIdAndNationId(Long typeId, Long nationId, Pageable pageable) {
		List<MovieDTO> models = new ArrayList<MovieDTO>();
		List<MovieEntity> movies = movieRepo.findAllByTypeIdAndNationId(typeId, nationId, pageable);
		for (MovieEntity movie : movies) {
			MovieDTO model = new MovieConverter().toDTO(movie);
			models.add(model);
		}
		return models;
	}

	@Override
	public List<MovieDTO> searchMovie(String keyword) {
		List<MovieDTO> models = new ArrayList<MovieDTO>();
		List<MovieEntity> movies = movieRepo.findByMovieNameContains(keyword);
		for (MovieEntity movie : movies) {
			MovieDTO model = new MovieConverter().toDTO(movie);
			models.add(model);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) movieRepo.count();
	}

	@Override
	public int getTotalItemByTypeId(Long typeId) {
		return (int) movieRepo.countByTypeId(typeId);
	}

	@Override
	public int getTotalItemByNationId(Long nationId) {
		return (int) movieRepo.countByNationId(nationId);
	}

	@Override
	public int getTotalItemByTypeIdAndNationId(Long typeId, Long nationId) {
		return (int) movieRepo.countByTypeIdAndNationId(typeId, nationId);
	}
}
