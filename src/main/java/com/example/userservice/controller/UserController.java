package com.example.userservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.Greeting;
import com.example.userservice.dto.Health;
import com.example.userservice.dto.User;
import com.example.userservice.exception.UserServiceException;
import com.example.userservice.service.UserService;

@RestController
public class UserController {
	private final Greeting greeting;
	private final UserService userService;

	public UserController(Greeting greeting, UserService userService) {
		this.greeting = greeting;
		this.userService = userService;
	}

	@GetMapping("/health")
	public ResponseEntity<Health.Response> status(HttpServletRequest request) {

		return ResponseEntity.ok(new Health.Response(true, request.getServerPort()));
	}

	@GetMapping("/welcome")
	public ResponseEntity<Greeting> welcome() {
		return ResponseEntity.ok(greeting);
	}

	@PostMapping("/users")
	public ResponseEntity registerUser(@RequestBody @Valid User.Request request) throws UserServiceException {
		User.UserInfo userInfo = request.toUserInfo();

		userService.registerUser(userInfo);

		return ResponseEntity.status(HttpStatus.CREATED)
							 .build();
	}
}
