package com.hardik.plutocracy.dto.request;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserLoginRequestDto {

	private final String emailid;
	private final String password;

}
