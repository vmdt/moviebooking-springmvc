package com.bookmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.MovieTypeEntity;

public interface MovieTypeRepository extends JpaRepository<MovieTypeEntity, Long> {
	
}
