package com.meritamerica.assignment7.model.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.meritamerica.assignment7.model.services.AuthService;

import DTO.SignupRequest;

@RestController
@RequestMapping("/Authenticate")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	///POST /Authenticate/CreateUser
	@PostMapping("/CreateUser")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createUser(@RequestBody @Valid SignupRequest signupRequest) {
		return authService.createUser(signupRequest);	
	}
	
	//POST /Authenticate
	//@ResponseStatus(HttpStatus.OK)
}
