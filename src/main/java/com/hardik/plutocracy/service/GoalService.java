package com.hardik.plutocracy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.GoalCreationRequestDto;
import com.hardik.plutocracy.dto.request.GoalUpdationRequestDto;
import com.hardik.plutocracy.repository.GoalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoalService {

	private final GoalRepository goalRepository;

	public ResponseEntity<?> create(final GoalCreationRequestDto goalCreationRequest, final String token) {
		return null;
	}

	public ResponseEntity<?> update(final GoalUpdationRequestDto goalUpdationRequest, final String token) {
		return null;
	}

	public ResponseEntity<?> retreive(final String token) {
		return null;
	}

}
