package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.CurrentMonthlySpendingThresholdLimitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrentMonthlySpendingThresholdLimitService {

	private final CurrentMonthlySpendingThresholdLimitRepository currentMonthlySpendingThresholdLimitRepository;

}
