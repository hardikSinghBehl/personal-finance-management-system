package com.hardik.plutocracy.dto.response;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JacksonStdImpl
public class SpendingThresholdRecordDto {

	private final Integer id;
	private final Double limitValue;
	private final Double valueSpent;
	private final String month;
	private final String year;

}
