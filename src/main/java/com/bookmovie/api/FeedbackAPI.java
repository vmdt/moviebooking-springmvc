package com.bookmovie.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmovie.dto.FeedbackDTO;
import com.bookmovie.service.IFeedbackService;

@RestController
public class FeedbackAPI {
	
	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping(value = "/api/feedbacks", method = RequestMethod.POST, consumes = {"*/*"})
	public FeedbackDTO createFeedback(@RequestBody FeedbackDTO feedback) {
		String datenow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		feedback.setCreateAt(datenow);
		return feedbackService.save(feedback);
	}
	
	@RequestMapping(value = "/api/feedbacks", method = RequestMethod.DELETE, consumes = {"*/*"})
	public void deleteFeedback(@RequestParam("userId") Long userId, @RequestParam("movieId") Long movieId) {
		feedbackService.deleteByUserIdAndMovieId(userId, movieId);
	}
	
}
