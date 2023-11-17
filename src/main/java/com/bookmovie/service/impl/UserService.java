package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.UserConverter;
import com.bookmovie.dto.UserDTO;
import com.bookmovie.entity.UserEntity;
import com.bookmovie.repository.RoleRepository;
import com.bookmovie.repository.UserRepository;
import com.bookmovie.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO user) {
		UserEntity newUser = new UserEntity();
		if (user.getId() != null) {
			UserEntity oldUser = userRepo.findOne(user.getId());
			if (user.getFullname() != null)
				oldUser.setFullname(user.getFullname());
			if (user.getEmail() != null)
				oldUser.setEmail(user.getEmail());
			if (user.getPhone() != null)
				oldUser.setPhone(user.getPhone());
			if (user.getUsername() != null)
				oldUser.setUsername(user.getUsername());
			if (user.getStatus() != null)
				oldUser.setStatus(user.getStatus());
			if (user.getRoleId() != null)
				oldUser.setRole(roleRepo.findOne(user.getRoleId()));
			return userConverter.toDTO(userRepo.save(oldUser));
		} else {
			newUser = userConverter.toEntity(user);
			if (user.getRoleId() != null)
				newUser.setRole(roleRepo.findOne(user.getRoleId()));
		}
		return userConverter.toDTO(userRepo.save(newUser));
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> models = new ArrayList<UserDTO>();
		List<UserEntity> users = userRepo.findAll(pageable).getContent();
		for (UserEntity user : users) {
			UserDTO model = userConverter.toDTO(user);
			models.add(model);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) userRepo.count();
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity user = userRepo.findOne(id);
		return userConverter.toDTO(user);
	}

	@Override
	public UserDTO actionUser(Long id, String action) {
		UserEntity user = userRepo.findOne(id);
		System.out.println(action);
		if (user != null) {
			user.setStatus(action);
		}
		return userConverter.toDTO(userRepo.save(user));
	}

	@Override
	public UserDTO findOneByUsernameAndPassword(String username, String password) {
		UserEntity user = userRepo.findOneByUsernameAndPassword(username, password);
		if (user != null)
			return userConverter.toDTO(user);
		return null;
	}

	@Override
	public UserDTO findOneByUsername(String username) {
		UserEntity user = userRepo.findOneByUsername(username);
		if (user != null)
			return userConverter.toDTO(user);
		return null;
	}

}
