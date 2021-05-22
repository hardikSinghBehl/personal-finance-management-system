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

import com.hardik.plutocracy.dto.request.CompletedTicketCreationRequestDto;
import com.hardik.plutocracy.service.CompletedTicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/completed-ticket")
public class CompletedTicketController {

	private final CompletedTicketService completedTicketService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Creates a completed ticket for the logged-in user")
	public ResponseEntity<?> completedTicketCreationHandler(
			@RequestBody(required = true) final CompletedTicketCreationRequestDto completedTicketCreationRequest,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return completedTicketService.create(completedTicketCreationRequest, token);
	}

	@DeleteMapping(value = "/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Deletes a completed ticket for the logged-in user")
	public ResponseEntity<?> completedTicketDeletionHandler(
			@PathVariable(name = "ticketId", required = true) final UUID ticketId,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return completedTicketService.delete(ticketId, token);
	}

	@GetMapping(value = "/expense", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of completed expense tickets created by the logged-in user")
	public ResponseEntity<?> completedExpenseTicketRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return completedTicketService.retreiveExpenses(token);
	}

	@GetMapping(value = "/gain", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of completed gains tickets created by the logged-in user")
	public ResponseEntity<?> completedGainTicketRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return completedTicketService.retreiveGains(token);
	}

}
