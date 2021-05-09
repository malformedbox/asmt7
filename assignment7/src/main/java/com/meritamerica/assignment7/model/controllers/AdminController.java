package com.meritamerica.assignment7.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment7.model.AuthenticationRequest;
import com.meritamerica.assignment7.model.AuthenticationResponse;
import com.meritamerica.assignment7.model.MyUser;
import com.meritamerica.assignment7.model.repository.UserRepository;
import com.meritamerica.assignment7.model.security.service.UserDetailsServiceImpl;
import com.meritamerica.assignment7.model.util.JwtUtil;

@RestController
public class AdminController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String home() {
		return("<h1>Welcome</h1>");
	}
	@GetMapping("/user")
	public String user() {
		return("<h1>Welcome User</h1>");
	}
	@GetMapping("/admin")
	public String admin() {
		return("<h1>Welcome Admin</h1>");
	}
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@PostMapping(value = "/createUser")
	 public MyUser createUser(@RequestBody MyUser user) {
		userRepo.save(user);
		return user;
		
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
