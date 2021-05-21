package com.hardik.plutocracy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.UserCreationRequestDto;
import com.hardik.plutocracy.dto.request.UserLoginRequestDto;
import com.hardik.plutocracy.dto.request.UserPasswordUpdationRequestDto;
import com.hardik.plutocracy.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public ResponseEntity<?> createUser(final UserCreationRequestDto userCreationRequest) {
		return null;
	}

	public ResponseEntity<?> login(final UserLoginRequestDto userLoginRequestDto) {
		return null;
	}

	public ResponseEntity<?> updatePassword(final UserPasswordUpdationRequestDto userPasswordUpdationRequestDto,
			final String token) {
		return null;
	}

}
