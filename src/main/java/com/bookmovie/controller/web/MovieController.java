package com.bookmovie.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.FeedbackDTO;
import com.bookmovie.dto.MovieDTO;
import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.dto.NationDTO;
import com.bookmovie.dto.SeatDTO;
import com.bookmovie.dto.ShowTimingDTO;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.service.IFeedbackService;
import com.bookmovie.service.IMovieService;
import com.bookmovie.service.IMovieTypeService;
import com.bookmovie.service.INationService;
import com.bookmovie.service.ISeatService;
import com.bookmovie.service.IShowTimingService;

@Controller(value = "movieControllerOfWeb")
public class MovieController {
	
	@Autowired
	private ISeatService seatService;
	
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private IShowTimingService showTimingService;
	
	@Autowired
	private IMovieTypeService movieTypeService;
	
	@Autowired
	private INationService nationService;
	
	@Autowired
	private IFeedbackService feedbackService;
	
	
	@RequestMapping(value = "/movies/{movieId}/seats", method = RequestMethod.GET)
	public String renderSeatPage(@PathVariable("movieId") Long movieId, @RequestParam(value = "timeId", defaultValue = "1") String timeId, Model model) {
		List<ShowTimingDTO> times = showTimingService.findAll();
		MovieDTO movie = movieService.findById(movieId);
		List<SeatDTO> seats = seatService.findSeatsByMovieAndTime(movieId, Long.parseLong(timeId));
		Long seatTotal = (long) seats.size();
		List<MovieTypeDTO> types = movieTypeService.findAll();
		List<NationDTO> nations = nationService.findAll();
		
		//System.out.println(seats.get(0).getSeatCode());
		model.addAttribute("types", types);
		model.addAttribute("nations", nations);	
		model.addAttribute("movie", movie);
		model.addAttribute("times", times);
		model.addAttribute("seats", seats);
		model.addAttribute("seatTotal", seatTotal);
		return "/web/booking";
	}
	
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
	   public ModelAndView movieDetailsPage(@PathVariable("id") Long id) {
			List<MovieTypeDTO> types = movieTypeService.findAll();
			List<NationDTO> nations = nationService.findAll();
			List<FeedbackDTO> feedbacks = feedbackService.findAllByMovieId(id);
			MovieDTO movie = movieService.findById(id);
			ModelAndView mav = new ModelAndView("web/movie-details");
			mav.addObject("feedbacks", feedbacks);
			mav.addObject("movie", movie);
			mav.addObject("types", types);
			mav.addObject("nations", nations);
			return mav;
	   }
}
