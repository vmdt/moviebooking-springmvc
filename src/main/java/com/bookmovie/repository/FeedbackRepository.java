package com.bookmovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.FeedbackEntity;
import com.bookmovie.entity.key.FeedbackKey;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, FeedbackKey> {
	public FeedbackEntity findOneByUserIdAndMovieId(Long userId, Long movieId);
	public List<FeedbackEntity> findAllByMovieId(Long movieId);
	public void deleteByUserIdAndMovieId(Long userId, Long movieId);
}
