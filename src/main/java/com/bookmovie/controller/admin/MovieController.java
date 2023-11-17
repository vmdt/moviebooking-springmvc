package com.bookmovie.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.MovieDTO;
import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.dto.NationDTO;
import com.bookmovie.service.IMovieService;
import com.bookmovie.service.IMovieTypeService;
import com.bookmovie.service.INationService;

@Controller(value = "movieControllerOfAdmin")
public class MovieController {
	@Autowired
	private IMovieService movieService;
	
	@Autowired 
	private IMovieTypeService movieTypeService;
	
	@Autowired
	private INationService nationService;
	
	@RequestMapping(value = "/admin/movies/manage", method = RequestMethod.GET)
	public ModelAndView renderActionForm(@RequestParam(required = false) String id) {
		ModelAndView mav = new ModelAndView("/admin/movie/manage");
		List<MovieTypeDTO> types = movieTypeService.findAll();
		List<NationDTO> nations = nationService.findAll();
		
		if (id != null) {
			MovieDTO movie = movieService.findById(Long.parseLong(id));
			mav.addObject("movie", movie);
		}
		
		mav.addObject("types", types);
		mav.addObject("nations", nations);
		
	    return mav;
	}
	
//	@RequestMapping(value = "/admin/movies/manage", method = {RequestMethod.POST, RequestMethod.PUT})
//	public String postMovieCreation(@ModelAttribute("movie") MovieDTO movie) {
//		MovieDTO created = movieService.save(movie);
//		return "redirect:/admin/movies";
//	}
	
	@RequestMapping(value = "/admin/movies", method = RequestMethod.GET)
	public String getMovieList(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "2") int limit, ModelMap model) {
		MovieDTO movies = new MovieDTO();
		movies.setPage(page);
		movies.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		movies.setListMovies(movieService.findAll(pageable));
		movies.setTotalItem(movieService.getTotalItem());
		movies.setTotalPage((int) Math.ceil((double) movies.getTotalItem() / movies.getLimit()));
		model.addAttribute("movies", movies);
		return "/admin/movie/list";
	}
}
