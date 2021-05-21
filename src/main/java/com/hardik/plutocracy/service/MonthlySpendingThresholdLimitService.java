package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.MonthlySpendingThresholdLimitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MonthlySpendingThresholdLimitService {

	private final MonthlySpendingThresholdLimitRepository monthlySpendingThresholdLimitRepository;

}
