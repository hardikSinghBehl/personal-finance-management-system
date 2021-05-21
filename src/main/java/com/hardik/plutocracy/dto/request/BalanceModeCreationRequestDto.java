package com.hardik.plutocracy.dto.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class BalanceModeCreationRequestDto {

	@Schema(description = "Type of Balance Mode", example = "Bank", required = true)
	@NotBlank(message = "mode type must not be empty")
	private final String modeType;

	@Schema(description = "Balance mode name", example = "Kotak Mahindra Bank", required = true)
	@NotBlank(message = "name of balance mode must not be empty")
	private final String name;

	@Schema(description = "Monetory Value inside the balance mode", example = "20000", required = true)
	@NotBlank(message = "monetory value inside the mode must not be empty")
	private final Double value;
}
