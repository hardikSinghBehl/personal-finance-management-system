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
public class GoalUpdationRequestDto {

	@Schema(description = "Description of the created goal", example = "Some moderate long string", required = true)
	@NotBlank(message = "goal description must not be empty")
	@Max(value = 1000, message = "Description must not exceed 1000 characters")
	private final String description;

	@Schema(description = "active/inactive flag for note", example = "false", required = false)
	private final Boolean isActive;

}
