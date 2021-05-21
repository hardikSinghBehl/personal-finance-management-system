package com.hardik.plutocracy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.BalanceModeCreationRequestDto;
import com.hardik.plutocracy.dto.request.BalanceModeUpdationRequestDto;
import com.hardik.plutocracy.repository.BalanceModeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BalanceModeService {

	private final BalanceModeRepository balanceModeRepository;

	public ResponseEntity<?> create(final BalanceModeCreationRequestDto balanceModeCreationRequestDto,
			final String token) {
		return null;
	}

	public ResponseEntity<?> update(final BalanceModeUpdationRequestDto balanceModeUpdationRequestDto,
			final String token) {
		return null;
	}

	public ResponseEntity<?> retreive(final String token) {
		return null;
	}

}
