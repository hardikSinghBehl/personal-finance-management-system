package com.hardik.plutocracy.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BalanceModeType {

	BANK(1, "BANK"), CASH(2, "CASH"), RESOURCES_SALEABLE(3, "RESOURCES SALEABLE"), MONEY_LENT(4, "MONEY LENT"),
	OTHER(5, "OTHER");

	private final Integer id;
	private final String type;

}
