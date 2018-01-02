package com.ty.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.service.UserService;

@Controller
public class UserController {
	public UserController() {
		System.out.println("kaka");
	}
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/hello")
	public String test(){
		System.out.println("success");
		System.out.println(userService);
		return "success";
	}
}
