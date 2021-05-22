package com.hardik.plutocracy.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class BalanceModeDto {

	private final UUID id;
	private final String modeType;
	private final String name;
	private final Double value;
	private final boolean isActive;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
