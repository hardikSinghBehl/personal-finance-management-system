package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.NoteTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteTagMappingService {

	private final NoteTagMappingRepository noteTagMappingRepository;

}
