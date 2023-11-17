package com.bookmovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	public List<BookingEntity> findAllByUserId(Long userId);
}
