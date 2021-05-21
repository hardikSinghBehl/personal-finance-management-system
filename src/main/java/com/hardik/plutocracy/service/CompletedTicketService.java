package com.hardik.plutocracy.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.CompletedTicketCreationRequestDto;
import com.hardik.plutocracy.repository.CompletedTicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompletedTicketService {

	private final CompletedTicketRepository completedTicketRepository;

	public ResponseEntity<?> create(final CompletedTicketCreationRequestDto completedTicketCreationRequest,
			final String token) {
		return null;
	}

	public ResponseEntity<?> delete(final UUID ticketId, final String token) {
		return null;
	}

	public ResponseEntity<?> retreiveExpenses(final String token) {
		return null;
	}

	public ResponseEntity<?> retreiveGains(final String token) {
		return null;
	}

}
