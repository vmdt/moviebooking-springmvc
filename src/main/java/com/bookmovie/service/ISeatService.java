package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.SeatDTO;

public interface ISeatService {
	List<SeatDTO> findSeatsByMovieAndTime(Long movieId, Long showTimingId);
	void initSeats(Long movieId, Long timeId, int rows);
	public SeatDTO save(SeatDTO seat);
}
