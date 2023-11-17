package com.bookmovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
	List<SeatEntity> findByMovieIdAndShowTimingId(Long movieId, Long showTimingId); 
	
}
