package com.emuntiy.rest.webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emuntiy.rest.webservice.dto.LoginDto;
import com.emuntiy.rest.webservice.dto.UserDto;
import com.emuntiy.rest.webservice.response.LoginResponse;
import com.emuntiy.rest.webservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/save")
	public String saveUser(@RequestBody UserDto userDto) {
		
		String id=userService.addUser(userDto);
		
		return id;
	}
	
	@PostMapping(path = "/login")
	  public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
	    {
	        LoginResponse loginResponse = userService.loginUser(loginDto);
	        return ResponseEntity.ok(loginResponse);
	    }

}
