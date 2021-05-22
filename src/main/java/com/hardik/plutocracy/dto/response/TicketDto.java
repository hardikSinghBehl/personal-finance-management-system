package com.hardik.plutocracy.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class TicketDto {

	private final UUID id;
	private final BalanceModeDto balanceMode;
	private final String name;
	private final String description;
	private final String ticketType1;
	private final String ticketType2;
	private final Double value;
	private final LocalDate ticketCompletionDate;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
