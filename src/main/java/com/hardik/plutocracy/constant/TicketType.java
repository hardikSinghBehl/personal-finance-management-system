package com.hardik.plutocracy.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TicketType {

	EXPENSE(1, "EXPENSE"), GAIN(2, "GAIN");

	private final Integer id;
	private final String type;

}
