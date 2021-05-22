package com.hardik.plutocracy.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class GoalDto {

	private final UUID id;
	private final String title;
	private final String description;
	private final Boolean isActive;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
