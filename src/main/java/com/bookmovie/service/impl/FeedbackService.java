package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookmovie.converter.FeedbackConverter;
import com.bookmovie.dto.FeedbackDTO;
import com.bookmovie.entity.FeedbackEntity;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.entity.UserEntity;
import com.bookmovie.repository.FeedbackRepository;
import com.bookmovie.repository.MovieRepository;
import com.bookmovie.repository.UserRepository;
import com.bookmovie.service.IFeedbackService;

@Service
@Transactional
public class FeedbackService implements IFeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private FeedbackConverter feedbackConverter;

	@Override
	public FeedbackDTO save(FeedbackDTO feedback) {
		FeedbackEntity entity = feedbackRepo.findOneByUserIdAndMovieId(feedback.getUserId(), feedback.getMovieId());
		UserEntity user = userRepo.findOne(feedback.getUserId());
		MovieEntity movie = movieRepo.findOne(feedback.getMovieId());

		if (entity != null) {
			if (user != null)
				entity.setUser(user);
			if (movie != null)
				entity.setMovie(movie);
			entity.setContent(feedback.getContent());
			entity.setCreateAt(feedback.getCreateAt());
		} else {
			FeedbackEntity newEntity = new FeedbackEntity();
			if (user != null)
				newEntity.setUser(user);
			if (movie != null)
				newEntity.setMovie(movie);
			newEntity.setContent(feedback.getContent());
			newEntity.setCreateAt(feedback.getCreateAt());
			return feedbackConverter.toDTO(feedbackRepo.save(newEntity));
		}
		
		return feedbackConverter.toDTO(feedbackRepo.save(entity));
	}

	@Override
	public List<FeedbackDTO> findAllByMovieId(Long movieId) {
		List<FeedbackDTO> models = new ArrayList<FeedbackDTO>();
		List<FeedbackEntity> feedbacks = feedbackRepo.findAllByMovieId(movieId);
		for (FeedbackEntity feedback : feedbacks) {
			FeedbackDTO model = feedbackConverter.toDTO(feedback);
			models.add(model);
		}
		return models;
	}

	@Override
	public void deleteByUserIdAndMovieId(Long userId, Long movieId) {
		feedbackRepo.deleteByUserIdAndMovieId(userId, movieId);
	}
}
