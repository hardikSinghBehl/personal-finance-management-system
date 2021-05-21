package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.NoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteService {

	private final NoteRepository noteRepository;

}
