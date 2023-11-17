package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.SeatConverter;
import com.bookmovie.dto.SeatDTO;
import com.bookmovie.dto.ShowTimingDTO;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.entity.SeatEntity;
import com.bookmovie.entity.ShowTimingEntity;
import com.bookmovie.repository.MovieRepository;
import com.bookmovie.repository.SeatRepository;
import com.bookmovie.repository.ShowTimingRepository;
import com.bookmovie.service.ISeatService;

@Service
public class SeatService implements ISeatService {
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private SeatConverter seatConverter;
	
	@Autowired
	private ShowTimingRepository showTimingRepo;

	@Override
	public List<SeatDTO> findSeatsByMovieAndTime(Long movieId, Long showTimingId) {
		List<SeatDTO> models = new ArrayList<SeatDTO>();
		List<SeatEntity> seats = seatRepo.findByMovieIdAndShowTimingId(movieId, showTimingId);
		for (SeatEntity seat : seats) {
			SeatDTO model = seatConverter.toDTO(seat);
			models.add(model);
		}
		return models;
	}

	@Override
	public void initSeats(Long movieId, Long timeId, int rows) {
		char code = 'A';
		MovieEntity movie = movieRepo.findOne(movieId);
		ShowTimingEntity time = showTimingRepo.findOne(timeId);
		for (int i=0; i<rows; i++) {
			for (int j=1; j<=12; j++) {
				SeatEntity seat = new SeatEntity();
				String seatCode = code + String.valueOf(j);
				if (movie != null)
					seat.setMovie(movie);
				seat.setSeatCode(seatCode);
				seat.setStatus("available");
				seat.setPrice(50000);
				if (time != null)
					seat.setShowTiming(time);
				seatRepo.save(seat);
			}
			code++;
		}
	}

	@Override
	public SeatDTO save(SeatDTO seat) {
		SeatEntity newSeat = new SeatEntity();
		if (seat.getId() != null) {
			SeatEntity oldSeat = seatRepo.findOne(seat.getId());
			if (seat.getStatus() != null)
				oldSeat.setStatus(seat.getStatus());
			return seatConverter.toDTO(seatRepo.save(oldSeat));
		} else {
			newSeat = seatConverter.toEntity(seat);
		}
		return seatConverter.toDTO(seatRepo.save(newSeat));
	}
}
