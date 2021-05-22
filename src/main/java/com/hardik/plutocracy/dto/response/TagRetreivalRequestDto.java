package com.hardik.plutocracy.dto.response;

import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class TagRetreivalRequestDto {

	private final UUID contextId;
	private final String contextType;

}
