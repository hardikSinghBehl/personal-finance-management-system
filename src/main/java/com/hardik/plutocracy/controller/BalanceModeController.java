package com.hardik.plutocracy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.dto.request.BalanceModeCreationRequestDto;
import com.hardik.plutocracy.dto.request.BalanceModeUpdationRequestDto;
import com.hardik.plutocracy.service.BalanceModeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/balance-mode")
public class BalanceModeController {

	private final BalanceModeService balanceModeService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Creates a new mode of balance for the logged-in user")
	public ResponseEntity<?> balanceModeCreationHandler(
			@RequestBody(required = true) final BalanceModeCreationRequestDto balanceModeCreationRequestDto,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return balanceModeService.create(balanceModeCreationRequestDto, token);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Updates details of given mode of balance for the logged in user")
	public ResponseEntity<?> balanceModeUpdationHandler(
			@RequestBody(required = true) final BalanceModeUpdationRequestDto balanceModeUpdationRequestDto,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return balanceModeService.update(balanceModeUpdationRequestDto, token);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of balance modes of the logged in user")
	public ResponseEntity<?> balanceModeRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return balanceModeService.retreive(token);
	}
}
