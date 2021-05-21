package com.hardik.plutocracy.dto.request;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class BalanceModeUpdationRequestDto {

	@Schema(description = "Id of balance-mode to update", example = "206eb75b-384d-4c3e-89b3-c2b1f34322c1", required = true)
	@NotBlank(message = "balance-mode id must not be empty")
	private final UUID id;

	@Schema(description = "Monetory Value inside the balance mode", example = "20000", required = true)
	@NotBlank(message = "monetory value inside the mode must not be empty")
	private final Double value;

	@Schema(description = "active/inactive flag for note", example = "false", required = true)
	private final Boolean isActive;

}
