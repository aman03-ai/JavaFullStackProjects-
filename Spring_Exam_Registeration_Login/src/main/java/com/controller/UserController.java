package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.UserEntity;
import com.repository.UserRepo;
import com.service.UserService;
import com.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/registerform")
	//model interface saves all the attributes
	public String openRegister(Model model) {
		model.addAttribute("user", new UserEntity());
		return "register";
	}
	
	@PostMapping("/registerform")
	public String submitForm(@ModelAttribute("user") UserEntity ue,Model model) {
		boolean result =userservice.registerUser(ue);
		if(result)
			model.addAttribute("success", "User Registerred successfully......!");
		else
			model.addAttribute("error", "Try Again....!");
		return "register";
	}
	
	@PostMapping("/loginform")
	public String loginForm(@ModelAttribute("user") UserEntity ue,Model model) {
		UserEntity result =userservice.loginUser(ue.getId(),ue.getPass());
		if(result!=null) {
			model.addAttribute("success", "Login Successful");
			model.addAttribute("modelName", result.getUname());
			return "success";
		}
		else {
			model.addAttribute("error", "Try Again");
			return "login";
		}
	}

	@GetMapping("/loginform")
	public String openLogin(Model model) {
		model.addAttribute("user", new UserEntity());
		return "login";
	}
}
