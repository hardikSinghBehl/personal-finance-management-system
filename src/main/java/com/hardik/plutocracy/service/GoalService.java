package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.GoalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoalService {

	private final GoalRepository goalRepository;

}
