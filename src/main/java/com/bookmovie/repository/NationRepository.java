package com.bookmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.NationEntity;

public interface NationRepository extends JpaRepository<NationEntity, Long> {
}
