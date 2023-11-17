package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.UserDTO;
import com.bookmovie.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if (entity.getEmail() != null)
			dto.setEmail(entity.getEmail());
		dto.setFullname(entity.getFullname());
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setStatus(entity.getStatus());
		dto.setPhone(entity.getPhone());
		dto.setRoleId(entity.getRole().getId());
		dto.setRoleName(entity.getRole().getRoleName());
		return dto;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setStatus(dto.getStatus());
		entity.setPhone(dto.getPhone());
		entity.setUsername(dto.getUsername());
		entity.setFullname(dto.getFullname());
		return entity;
	}
}
