package com.hardik.plutocracy.dto.request;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserPasswordUpdationRequestDto {

	private final String oldPassword;
	private final String newPassword;

}
