package com.hardik.plutocracy.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.FutureTicketCreationRequestDto;
import com.hardik.plutocracy.repository.FutureTicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FutureTicketService {

	private final FutureTicketRepository futureTicketRepository;

	public ResponseEntity<?> create(final FutureTicketCreationRequestDto futureTicketCreationRequestDto,
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
