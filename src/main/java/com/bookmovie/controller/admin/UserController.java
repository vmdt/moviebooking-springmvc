package com.bookmovie.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.RoleDTO;
import com.bookmovie.dto.UserDTO;
import com.bookmovie.service.IRoleService;
import com.bookmovie.service.IUserService;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String getUserList(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int limit, ModelMap model) {
		UserDTO users = new UserDTO();
		users.setPage(page);
		users.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		users.setListUsers(userService.findAll(pageable));
		users.setTotalItem(userService.getTotalItem());
		users.setTotalPage((int) Math.ceil((double) users.getTotalItem() / users.getLimit()));
		model.addAttribute("users", users);
		return "/admin/user/list";
	}
	
	@RequestMapping(value = "/admin/users/manage", method = RequestMethod.GET)
	public ModelAndView renderActionForm(@RequestParam(required = false) String id) {
		ModelAndView mav = new ModelAndView("/admin/user/manage");
		List<RoleDTO> roles = roleService.findAll();
		mav.addObject("roles", roles);
		if (id != null) {
			UserDTO user = userService.findById(Long.parseLong(id));
			mav.addObject("user", user);
		}
		return mav;
	}
	
}
