package com.hardik.plutocracy.dto.request;

import java.time.LocalDate;

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
public class UserCreationRequestDto {

	@Schema(description = "Email-id of the user", example = "abc@example.com", required = true)
	@NotBlank(message = "email-id must not be empty")
	@Email(message = "please enter a valid email id")
	private final String emailId;

	@Schema(description = "password for the user", example = "somethingStrong", required = true)
	@NotBlank(message = "password must not be empty")
	@Size(min = 8, max = 20, message = "password should be between 8 and 20 characters")
	private final String password;

	@Schema(description = "First Name of the user", example = "Hardik", required = true)
	@NotBlank(message = "first-name must not be empty")
	@Max(value = 50, message = "first-name should be under 50 characters in length")
	private final String firstName;

	@Schema(description = "Last Name of the user", example = "Behl", required = true)
	@NotBlank(message = "last-name must not be empty")
	@Max(value = 50, message = "last-name should be under 50 characters in length")
	private final String lastName;

	@Schema(description = "Date of Birth of the user", example = "1999-12-25", required = true)
	@NotBlank(message = "date-of-birth must not be empty")
	private final LocalDate dateOfBirth;

}
