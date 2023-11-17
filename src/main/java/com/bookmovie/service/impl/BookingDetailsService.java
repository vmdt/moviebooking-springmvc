package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.BookingDetailsConverter;
import com.bookmovie.converter.MovieConverter;
import com.bookmovie.dto.BookingDetailsDTO;
import com.bookmovie.entity.BookingDetailsEntity;
import com.bookmovie.entity.BookingEntity;
import com.bookmovie.entity.MovieEntity;
import com.bookmovie.entity.SeatEntity;
import com.bookmovie.repository.BookingDetailsRepository;
import com.bookmovie.repository.BookingRepository;
import com.bookmovie.repository.MovieRepository;
import com.bookmovie.repository.SeatRepository;
import com.bookmovie.service.IBookingDetailsService;

@Service
@Transactional
public class BookingDetailsService implements IBookingDetailsService {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private MovieConverter movieConverter;
	
	@Autowired
	private BookingDetailsConverter bookingDetailsConverter;

	@Override
	public BookingDetailsDTO save(BookingDetailsDTO model) {
		BookingDetailsEntity entity = bookingDetailsRepo.findOneByBookingIdAndSeatId(model.getBookingId(), model.getSeatId());
		BookingEntity booking = bookingRepo.findOne(model.getBookingId());
		SeatEntity seat = seatRepo.findOne(model.getSeatId());
		if (entity != null) {
			entity.setBookingTime(model.getBookingTime());
			entity.setBooking(booking);
			entity.setSeat(seat);
		} else {
			BookingDetailsEntity newEntity = new BookingDetailsEntity();
			newEntity.setBooking(booking);
			newEntity.setSeat(seat);
			newEntity.setBookingTime(model.getBookingTime());
			return bookingDetailsConverter.toDTO(bookingDetailsRepo.save(newEntity));
		}
		return bookingDetailsConverter.toDTO(bookingDetailsRepo.save(entity));
	}

	@Override
	public List<BookingDetailsDTO> findAllByBookingId(Long bookingId) {
		List<BookingDetailsDTO> models = new ArrayList<BookingDetailsDTO>();
		List<BookingDetailsEntity> entities = bookingDetailsRepo.findAllByBookingId(bookingId);
		
		for (BookingDetailsEntity entity : entities) {
			BookingDetailsDTO model = bookingDetailsConverter.toDTO(entity);
			// get movie for movie dto
			MovieEntity movie = movieRepo.findOne(entity.getSeat().getMovie().getId());
			model.setMovieName(movie.getMovieName());
			model.setShowTiming(entity.getSeat().getShowTiming().getTime());
			models.add(model);
		}
		return models;
	}

	@Override
	public void deleteByBookingIdAndSeatId(Long bid, Long sid) {
		bookingDetailsRepo.deleteByBookingIdAndSeatId(bid, sid);
	}
}
