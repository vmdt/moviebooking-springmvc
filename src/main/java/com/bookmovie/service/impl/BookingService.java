package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.BookingConverter;
import com.bookmovie.dto.BookingDTO;
import com.bookmovie.entity.BookingEntity;
import com.bookmovie.repository.BookingRepository;
import com.bookmovie.repository.UserRepository;
import com.bookmovie.service.IBookingService;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookingConverter bookingConverter;
	
	@Override
	public BookingDTO findById(Long id) {
		BookingEntity booking = bookingRepo.findOne(id);
		return bookingConverter.toDTO(booking);
	}

	@Override
	public BookingDTO save(BookingDTO model) {
		BookingEntity newBooking = new BookingEntity();
		if (model.getId() != null) {
			BookingEntity oldBooking = bookingRepo.findOne(model.getId());
			if (model.getUserId() != null)
				oldBooking.setUser(userRepo.findOne(model.getId()));
			if (model.getStatus() != null)
				oldBooking.setStatus(model.getStatus());
			oldBooking.setTotalPrice(model.getTotalPrice());
			return bookingConverter.toDTO(bookingRepo.save(oldBooking));
		} else {
			newBooking = bookingConverter.toEntity(model);
			if (model.getUserId() != null)
				newBooking.setUser(userRepo.findOne(model.getUserId()));
		}
		return bookingConverter.toDTO(bookingRepo.save(newBooking));
	}

	@Override
	public void deleteById(Long id) {
		bookingRepo.delete(id);
	}

	@Override
	public List<BookingDTO> findAllByUserId(Long userId) {
		List<BookingDTO> models = new ArrayList<BookingDTO>();
		List<BookingEntity> bookings = bookingRepo.findAllByUserId(userId);
		for (BookingEntity booking : bookings) {
			BookingDTO model = bookingConverter.toDTO(booking);
			models.add(model);
		}
		return models;
	}
	
}
