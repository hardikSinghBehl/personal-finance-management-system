package com.hardik.plutocracy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.dto.response.TagRetreivalRequestDto;
import com.hardik.plutocracy.service.TagService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/tags")
public class TagController {

	private final TagService tagService;

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of tags for a context")
	public ResponseEntity<?> tagRetreivalHandler(
			@RequestBody(required = true) TagRetreivalRequestDto tagRetreivalRequest,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return tagService.retreive(tagRetreivalRequest, token);
	}
}
