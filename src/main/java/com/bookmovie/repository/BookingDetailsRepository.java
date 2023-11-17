package com.bookmovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.BookingDetailsEntity;
import com.bookmovie.entity.key.BookingDetailsKey;

public interface BookingDetailsRepository extends JpaRepository<BookingDetailsEntity, BookingDetailsKey> {
	public List<BookingDetailsEntity> findAllByBookingId(Long bookingId);
	public BookingDetailsEntity findOneByBookingIdAndSeatId(Long bid, Long sid);
	public void deleteByBookingIdAndSeatId(Long bid, Long sid);
}
