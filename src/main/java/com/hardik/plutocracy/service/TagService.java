package com.hardik.plutocracy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hardik.plutocracy.entity.Tag;
import com.hardik.plutocracy.repository.TagRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagService {

	private final TagRepository tagRepository;

	public List<Tag> retreive() {
		return tagRepository.findAll();
	}

}
