package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.TotalBalanceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TotalBalanceService {

	private final TotalBalanceRepository totalBalanceRepository;

}
