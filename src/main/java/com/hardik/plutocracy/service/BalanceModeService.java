package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.BalanceModeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BalanceModeService {

	private final BalanceModeRepository balanceModeRepository;

}
