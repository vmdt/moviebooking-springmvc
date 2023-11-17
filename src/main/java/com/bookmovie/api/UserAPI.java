package com.bookmovie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmovie.dto.UserDTO;
import com.bookmovie.service.IUserService;

@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = {"*/*"})
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.save(user);
	}
	
	
	@RequestMapping(value = "/api/users", method = RequestMethod.PUT, consumes = {"*/*"})
	public UserDTO updateUser(@RequestBody UserDTO user) {
		return userService.save(user);
	}
	
	
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PATCH, consumes = {"*/*"})
	public UserDTO actionUser(@PathVariable("id") Long id, @RequestParam(value="action", required = false) String action) {
		return userService.actionUser(id, action);
	}
	
}
