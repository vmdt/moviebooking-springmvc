package com.bookmovie.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.MovieDTO;
import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.dto.NationDTO;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.service.IMovieService;
import com.bookmovie.service.IMovieTypeService;
import com.bookmovie.service.INationService;

@Controller
public class HomeController {
	@Autowired
	private IMovieService movieService;

	@Autowired
	private IMovieTypeService movieTypeService;

	@Autowired
	private INationService nationService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		MovieDTO movies = new MovieDTO();
		List<MovieTypeDTO> types = movieTypeService.findAll();
		List<NationDTO> nations = nationService.findAll();
		ModelAndView mav = new ModelAndView("web/home");
		Pageable pageable = new PageRequest(0, 8);
		movies.setListMovies(movieService.findAll(pageable));
		mav.addObject("types", types);
		mav.addObject("nations", nations);
		mav.addObject("movies", movies);
		return mav;
	}

	@RequestMapping(value = "/movies-list", method = RequestMethod.GET)
	public ModelAndView moviesPage(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "8") int limit,
			@RequestParam(value = "typeId", defaultValue="-1") Long typeId,
			@RequestParam(value = "nationId", defaultValue="-1") Long nationId,
			@RequestParam(value = "q", required=false) String query) {
		List<MovieTypeDTO> types = movieTypeService.findAll();
		List<NationDTO> nations = nationService.findAll();
		ModelAndView mav = new ModelAndView("web/movies-list");
		MovieDTO movies = new MovieDTO();
		movies.setPage(page);
		movies.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		
		// handle filter movie by type and nation
		if (typeId != -1 && nationId != -1) {
			movies.setListMovies(movieService.findAllByTypeIdAndNationId(typeId, nationId, pageable));
			movies.setTotalItem(movieService.getTotalItemByTypeIdAndNationId(typeId, nationId));
		} else if (typeId != -1) {
			movies.setListMovies(movieService.findAllByTypeId(typeId, pageable));
			movies.setTotalItem(movieService.getTotalItemByTypeId(typeId));
		} else if (nationId != -1) {
			movies.setListMovies(movieService.findAllByNationId(nationId, pageable));
			movies.setTotalItem(movieService.getTotalItemByNationId(nationId));
		} else {
			movies.setListMovies(movieService.findAll(pageable));
			movies.setTotalItem(movieService.getTotalItem());
		}
		
		// handle searching movie by query keyword
		if (query != null) {
			List<MovieDTO> searched = movieService.searchMovie(query);
			movies.setListMovies(searched);
			movies.setTotalItem(searched.size());
		}
			
		movies.setTotalPage((int) Math.ceil((double) movies.getTotalItem() / movies.getLimit()));
		mav.addObject("movies", movies);
		mav.addObject("types", types);
		mav.addObject("nations", nations);
		return mav;
		
	}

}
