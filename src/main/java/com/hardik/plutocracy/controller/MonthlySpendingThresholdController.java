package com.hardik.plutocracy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.plutocracy.dto.request.MonthlySpendingThresholdLimitRequestDto;
import com.hardik.plutocracy.dto.response.SpendingThresholdRecordDto;
import com.hardik.plutocracy.service.CurrentMonthlySpendingThresholdLimitService;
import com.hardik.plutocracy.service.SpendingThresholdRecordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/monthly-spending-threshold")
public class MonthlySpendingThresholdController {

	private final CurrentMonthlySpendingThresholdLimitService currentMonthlySpendingThresholdLimitService;

	private final SpendingThresholdRecordService spendingThresholdRecordService;

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Updates details for monthly-spending-threshold")
	public ResponseEntity<?> monthlySpendingThresholdUpdationHandler(
			@RequestBody(required = true) final MonthlySpendingThresholdLimitRequestDto monthlySpendingThresholdLimitRequest,
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return currentMonthlySpendingThresholdLimitService.update(monthlySpendingThresholdLimitRequest, token);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns list of user's past monthly spending records")
	public ResponseEntity<List<SpendingThresholdRecordDto>> boom(
			@RequestHeader(name = "Authorization", required = true) @Parameter(hidden = true) final String token) {
		return spendingThresholdRecordService.retreivePastRecords(token);
	}

}
