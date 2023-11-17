package com.bookmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.ShowTimingEntity;

public interface ShowTimingRepository extends JpaRepository<ShowTimingEntity, Long> {

}
