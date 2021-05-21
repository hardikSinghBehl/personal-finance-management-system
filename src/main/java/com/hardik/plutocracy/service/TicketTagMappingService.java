package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.TicketTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketTagMappingService {

	private final TicketTagMappingRepository ticketTagMappingRepository;

}
