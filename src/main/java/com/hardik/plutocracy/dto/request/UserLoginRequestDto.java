package com.hardik.plutocracy.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserLoginRequestDto {

	@Schema(description = "Email-id of the user", example = "abc@example.com", required = true)
	@NotBlank(message = "email-id must not be empty")
	@Email(message = "please enter a valid email id")
	@Max(value = 50, message = "email-id should not exceed 50 characters")
	private final String emailId;

	@Schema(description = "password for the user", example = "somethingStrong", required = true)
	@NotBlank(message = "password must not be empty")
	@Size(min = 8, max = 20, message = "password should be between 8 and 20 characters")
	private final String password;

}
