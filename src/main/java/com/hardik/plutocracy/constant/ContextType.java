package com.hardik.plutocracy.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContextType {

	COMPLETED_TICKET(1, "Completed Ticket"), FUTURE_TICKET(2, "Future Ticket"), NOTE(3, "Notes");

	private final Integer id;
	private final String name;

}
