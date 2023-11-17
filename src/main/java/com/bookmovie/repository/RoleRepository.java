package com.bookmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
}
