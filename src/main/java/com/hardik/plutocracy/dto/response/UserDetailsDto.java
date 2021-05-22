package com.hardik.plutocracy.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserDetailsDto {

	private final String emailId;
	private final String firstName;
	private final String lastName;
	private final LocalDate dateOfBirth;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
