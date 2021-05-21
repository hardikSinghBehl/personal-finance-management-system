package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.CompletedTicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompletedTicketService {

	private final CompletedTicketRepository completedTicketRepository;

}
