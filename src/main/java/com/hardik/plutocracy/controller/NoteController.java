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

import com.hardik.plutocracy.dto.request.NoteCreationRequestDto;
import com.hardik.plutocracy.dto.request.NoteUpdationRequestDto;
import com.hardik.plutocracy.service.NoteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/note")
@AllArgsConstructor
public class NoteController {

	private final NoteService noteService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Creates a note for the logged in user")
	public ResponseEntity<?> noteCreationHandler(
			@RequestBody(required = true) final NoteCreationRequestDto noteCreationRequest,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return noteService.create(noteCreationRequest, token);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Updates details of given note for the logged in user")
	public ResponseEntity<?> noteUpdationHandler(
			@RequestBody(required = true) final NoteUpdationRequestDto noteUpdationRequest,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return noteService.update(noteUpdationRequest, token);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of notes created by logged-in user")
	public ResponseEntity<?> noteRetreivalHandler(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return noteService.retreive(token);
	}

}
