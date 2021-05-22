package com.hardik.plutocracy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.utils.ResponseUtils;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/master")
public class MasterController {

	private final ResponseUtils responseUtils;

	@GetMapping("/health-check/ping")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Endpoint to check if service is up or not")
	public ResponseEntity<?> serviceHealthCheckerHandler() {
		return responseUtils.pingResponse();
	}

	@GetMapping("/ticket-type")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns List of Valid values of ticket type")
	public ResponseEntity<?> ticketTypesRetreivalHandler() {
		return responseUtils.ticketTypeListResponse();
	}

	@GetMapping("/balance-mode-type")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns List of values of Balance mode type (can be custom)")
	public ResponseEntity<?> balanceModeTypeRetreivalHandler() {
		return responseUtils.balanceModeTypeListResponse();
	}

}
