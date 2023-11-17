package com.bookmovie.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookmovie.dto.MovieTypeDTO;
import com.bookmovie.dto.NationDTO;
import com.bookmovie.dto.UserDTO;
import com.bookmovie.service.IMovieTypeService;
import com.bookmovie.service.INationService;
import com.bookmovie.service.IUserService;

@Controller
public class AuthController {
	
	@Autowired
	private IMovieTypeService movieTypeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private INationService nationService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") UserDTO user, HttpServletRequest request) {
		UserDTO checkUser = userService.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if (checkUser != null) {
			if (checkUser.getStatus().equals("ban"))
				return "redirect:login?message=banned";
			else {
				HttpSession session = request.getSession();
				// remove the password for input
				checkUser.setPassword("");
				session.setAttribute("acc", checkUser);
				return "redirect:home";
			}
		}
		return "redirect:login?message=incorrect";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("acc");
		return "redirect:home";
    }
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupPage() {
		ModelAndView mav = new ModelAndView("web/signup");
		return mav;
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("user") UserDTO user,  HttpServletRequest request) {
		UserDTO existUser = new UserDTO();
		if (user.getUsername() != null)
			existUser = userService.findOneByUsername(user.getUsername());
		if (existUser != null)
			return "redirect:signup?message=exist";
		
		// set default value for some fields
		user.setEmail("");
		user.setStatus("active");
		user.setPhone("");
		user.setRoleId((long)1);
		
		UserDTO newUser = userService.save(user);
		HttpSession session = request.getSession();
		// remove the password for input
		newUser.setPassword("");
		session.setAttribute("acc", newUser);
			
		return "redirect:home";
    }
	
}
