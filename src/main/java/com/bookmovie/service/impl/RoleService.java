package com.bookmovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.converter.RoleConverter;
import com.bookmovie.dto.RoleDTO;
import com.bookmovie.entity.RoleEntity;
import com.bookmovie.repository.RoleRepository;
import com.bookmovie.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private RoleConverter roleConverter;

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> models = new ArrayList<RoleDTO>();
		List<RoleEntity> roles = roleRepo.findAll();
		for (RoleEntity role : roles) {
			RoleDTO model = roleConverter.toDTO(role);
			models.add(model);
		}
		return models;
	}

}
