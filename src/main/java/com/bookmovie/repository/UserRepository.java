package com.bookmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmovie.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findOneByUsernameAndPassword(String username, String password);
	public UserEntity findOneByUsername(String username);
}
