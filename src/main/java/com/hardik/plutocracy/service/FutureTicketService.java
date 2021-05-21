package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.FutureTicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FutureTicketService {

	private final FutureTicketRepository futureTicketRepository;

}
