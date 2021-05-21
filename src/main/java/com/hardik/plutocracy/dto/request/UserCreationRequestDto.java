package com.hardik.plutocracy.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserCreationRequestDto {

	private final String emailId;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final LocalDate dateOfBirth;

}
