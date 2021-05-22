package com.hardik.plutocracy.dto.request;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class NoteUpdationRequestDto {

	@Schema(description = "Description of the created note", example = "Probably Not a good idea", required = true)
	@NotBlank(message = "note description must not be empty")
	@Max(value = 2000, message = "Description must not exceed 2000 characters")
	private final String description;

	@Schema(description = "active/inactive flag for note", example = "false", required = false)
	private final Boolean isActive;

	@Schema(description = "List of tags to associate with note", required = false)
	private final List<TagCreationRequestDto> tags;

}
