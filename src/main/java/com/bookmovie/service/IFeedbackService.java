package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.FeedbackDTO;

public interface IFeedbackService {
	public FeedbackDTO save(FeedbackDTO feedback);
	public List<FeedbackDTO> findAllByMovieId(Long movieId);
	public void deleteByUserIdAndMovieId(Long userId, Long movieId);
}
