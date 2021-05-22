package com.hardik.plutocracy.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class CompletedTicketCreationRequestDto {

	@Schema(description = "id of balance mode under which ticket is being created", example = "4d8e5a8b-7716-4a3f-8250-244e05ec58ba", required = true)
	@NotBlank(message = "balance-mode-id must not be empty")
	private final UUID balanceModeId;

	@Schema(description = "name/title of Created Ticket", example = "lent money to guddu", required = true)
	@NotBlank(message = "name must not be empty")
	private final String name;

	@Schema(description = "Description of Created Ticket", required = true)
	@NotBlank(message = "description must not be empty")
	private final String description;

	@Schema(description = "type of ticket (expense/gain)", example = "expense", required = true)
	@NotBlank(message = "Ticket type must not be empty")
	private final String ticketType;

	@Schema(description = "Monetory Value inside the Ticket", example = "500", required = true)
	@NotBlank(message = "monetory value of created ticket must not be empty")
	private final Double value;

	@Schema(description = "Date on which ticket was settled", example = "2021-05-14", required = true)
	@NotBlank(message = "ticket completion date value must not be empty")
	private final LocalDate ticketCompletionDate;

	@Schema(description = "List of tags to associate with ticket", required = false)
	private final List<TagCreationRequestDto> tags;

}
