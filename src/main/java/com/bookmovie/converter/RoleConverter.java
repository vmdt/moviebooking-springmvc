package com.bookmovie.converter;

import org.springframework.stereotype.Component;

import com.bookmovie.dto.RoleDTO;
import com.bookmovie.entity.RoleEntity;

@Component
public class RoleConverter {
	public RoleDTO toDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		dto.setId(entity.getId());
		dto.setRoleName(entity.getRoleName());
		return dto;
	}

	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setId(dto.getId());
		entity.setRoleName(dto.getRoleName());
		return entity;
	}
}
