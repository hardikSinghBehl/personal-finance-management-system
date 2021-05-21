package com.hardik.plutocracy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.NoteCreationRequestDto;
import com.hardik.plutocracy.dto.request.NoteUpdationRequestDto;
import com.hardik.plutocracy.repository.NoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteService {

	private final NoteRepository noteRepository;

	public ResponseEntity<?> create(final NoteCreationRequestDto noteCreationRequest, final String token) {
		return null;
	}

	public ResponseEntity<?> update(final NoteUpdationRequestDto noteUpdationRequest, final String token) {
		return null;
	}

	public ResponseEntity<?> retreive(final String token) {
		return null;
	}

}
