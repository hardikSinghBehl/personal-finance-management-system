package com.hardik.plutocracy.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class UserDetailUpdationRequestDto {

	@Schema(description = "new first-name of user", example = "Hardik Singh", required = true)
	@NotBlank(message = "first-name value should not be empty")
	@Max(value = 50, message = "last-nam eshould not exceed more than 50 characters")
	private final String firstName;

	@Schema(description = "new last-name of user", example = "Behlol", required = true)
	@NotBlank(message = "last-name value should not be empty")
	@Max(value = 50, message = "last-nam eshould not exceed more than 50 characters")
	private final String lastName;

	@Schema(description = "new date-pf-birth of user", example = "1999-12-24", required = true)
	@NotBlank(message = "DOB value should not be empty")
	private final LocalDate dateOfBirth;

}
