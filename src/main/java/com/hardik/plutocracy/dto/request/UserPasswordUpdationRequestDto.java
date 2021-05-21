package com.hardik.plutocracy.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserPasswordUpdationRequestDto {

	@Schema(description = "Existing Password of the user", example = "somthingBig", required = true)
	@NotBlank(message = "old-password must not be empty")
	@Size(min = 8, max = 20, message = "password should be between 8 and 20 characters")
	private final String oldPassword;

	@Schema(description = "New password for the user", example = "somethingSmall", required = true)
	@NotBlank(message = "new password must not be empty")
	@Size(min = 8, max = 20, message = "password should be between 8 and 20 characters")
	private final String newPassword;

}
