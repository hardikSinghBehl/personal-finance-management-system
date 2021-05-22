package com.hardik.plutocracy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.dto.request.UserCreationRequestDto;
import com.hardik.plutocracy.dto.request.UserLoginRequestDto;
import com.hardik.plutocracy.dto.request.UserPasswordUpdationRequestDto;
import com.hardik.plutocracy.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthenticationController {

	private final UserService userService;

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Registers a new user with the system")
	public ResponseEntity<?> userCreationHandler(
			@RequestBody(required = true) final UserCreationRequestDto userCreationRequest) {
		return userService.createUser(userCreationRequest);
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a JWT representing the user that can be used for authentication")
	public ResponseEntity<?> userLoginHandler(
			@RequestBody(required = true) final UserLoginRequestDto userLoginRequestDto) {
		return userService.login(userLoginRequestDto);
	}

	@PutMapping(value = "/update-password", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Changes the password of the logged in user")
	public ResponseEntity<?> userPasswordUpdationHandler(
			@RequestBody(required = true) final UserPasswordUpdationRequestDto userPasswordUpdationRequestDto,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return userService.updatePassword(userPasswordUpdationRequestDto, token);
	}

}
