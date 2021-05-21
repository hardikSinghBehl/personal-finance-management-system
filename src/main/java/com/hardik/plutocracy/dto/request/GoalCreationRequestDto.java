package com.hardik.plutocracy.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class GoalCreationRequestDto {

	@Schema(description = "Title of the created goal", example = "Invest in Dogecoin", required = true)
	@NotBlank(message = "goal title must not be empty")
	@Max(value = 100, message = "Title must not exceed 100 characters")
	private final String title;

	@Schema(description = "Description of the created goal", example = "Probably Not a good idea", required = true)
	@NotBlank(message = "goal description must not be empty")
	@Max(value = 1000, message = "Description must not exceed 1000 characters")
	private final String description;

}
