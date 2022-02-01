package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.model.User;
import com.pack.service.UserService;

@Controller
public class UserController
{
	@Autowired
	UserService userService;
	@RequestMapping("/toAdd")
public String toAdd(Model m)
{
	m.addAttribute("userBean",new User());
	return "Login";
}
	@RequestMapping("/Add")
	public String add(User user)
	{
		userService.addUser(user);
		return "Welcome";
		
	}
}
