package com.bookmovie.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bookmovie.dto.UserDTO;

public interface IUserService {
	public UserDTO save(UserDTO user);
	public List<UserDTO> findAll(Pageable pageable);
	public int getTotalItem();
	public UserDTO findById(Long id);
	public UserDTO actionUser(Long id, String action);
	public UserDTO findOneByUsernameAndPassword(String username, String password);
	public UserDTO findOneByUsername(String username);
}
