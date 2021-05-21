package com.hardik.plutocracy.service;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.repository.TagRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagService {

	private final TagRepository tagRepository;

}
