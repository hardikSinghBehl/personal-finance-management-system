package com.hardik.plutocracy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.MonthlySpendingThresholdLimitRequestDto;
import com.hardik.plutocracy.repository.CurrentMonthlySpendingThresholdLimitRepository;
import com.hardik.plutocracy.security.utility.JwtUtils;
import com.hardik.plutocracy.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrentMonthlySpendingThresholdLimitService {

	private final CurrentMonthlySpendingThresholdLimitRepository currentMonthlySpendingThresholdLimitRepository;
	private final JwtUtils jwtUtils;
	private final ResponseUtils responseUtils;

	public ResponseEntity<?> update(final MonthlySpendingThresholdLimitRequestDto monthlySpendingThresholdLimitRequest,
			final String token) {
		final var currentMonthlySpendingThresholdLimit = currentMonthlySpendingThresholdLimitRepository
				.findByUserId(jwtUtils.extractUserId(token.replace("Bearer ", ""))).get();

		currentMonthlySpendingThresholdLimit.setIsActive(monthlySpendingThresholdLimitRequest.getActive());
		currentMonthlySpendingThresholdLimit.setLimitValue(monthlySpendingThresholdLimitRequest.getLimitValue());

		currentMonthlySpendingThresholdLimitRepository.save(currentMonthlySpendingThresholdLimit);
		return responseUtils.monthlySpendingUpdationSuccessResponse();
	}

}
