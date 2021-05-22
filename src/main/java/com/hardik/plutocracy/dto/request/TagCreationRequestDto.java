package com.hardik.plutocracy.dto.request;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class TagCreationRequestDto {

	@Schema(description = "name of tag", example = "bitcoin", required = true)
	private final String name;

}
