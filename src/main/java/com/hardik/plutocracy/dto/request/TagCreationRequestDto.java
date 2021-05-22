package com.hardik.plutocracy.dto.request;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JacksonStdImpl
public class TagCreationRequestDto {

	@Schema(description = "name of tag", example = "bitcoin", required = true)
	private String name;

}
