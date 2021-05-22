package com.hardik.plutocracy.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.dto.request.FutureTicketCreationRequestDto;
import com.hardik.plutocracy.service.FutureTicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/future-ticket")
public class FutureTicketController {

	private final FutureTicketService futureTicketService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Creates a future ticket for the logged-in user")
	public ResponseEntity<?> futureTicketCreationHandler(
			@RequestBody(required = true) final FutureTicketCreationRequestDto futureTicketCreationRequestDto,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return futureTicketService.create(futureTicketCreationRequestDto, token);
	}

	@DeleteMapping(value = "/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Deletes a future ticket for the logged-in user")
	public ResponseEntity<?> futureTicketDeletionHandler(
			@PathVariable(name = "ticketId", required = true) final UUID ticketId,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return futureTicketService.delete(ticketId, token);
	}

	@GetMapping(value = "/expense", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of future expense tickets created by the logged-in user")
	public ResponseEntity<?> futureExpenseTicketRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return futureTicketService.retreiveExpenses(token);
	}

	@GetMapping(value = "/gain", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of future gains tickets created by the logged-in user")
	public ResponseEntity<?> futureGainTicketRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return futureTicketService.retreiveGains(token);
	}

}
