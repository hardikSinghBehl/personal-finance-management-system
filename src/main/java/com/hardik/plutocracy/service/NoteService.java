package com.hardik.plutocracy.service;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.request.NoteCreationRequestDto;
import com.hardik.plutocracy.dto.request.NoteUpdationRequestDto;
import com.hardik.plutocracy.dto.response.NoteDto;
import com.hardik.plutocracy.entity.Note;
import com.hardik.plutocracy.entity.NoteTagMapping;
import com.hardik.plutocracy.entity.Tag;
import com.hardik.plutocracy.repository.NoteRepository;
import com.hardik.plutocracy.repository.NoteTagMappingRepository;
import com.hardik.plutocracy.repository.TagRepository;
import com.hardik.plutocracy.repository.UserRepository;
import com.hardik.plutocracy.security.utility.JwtUtils;
import com.hardik.plutocracy.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteService {

	private final NoteRepository noteRepository;

	private final UserRepository userRepository;

	private final TagRepository tagRepository;

	private final NoteTagMappingRepository noteTagMappingRepository;

	private final JwtUtils jwtUtils;

	private final ResponseUtils responseUtils;

	public ResponseEntity<?> create(final NoteCreationRequestDto noteCreationRequest, final String token) {
		final var note = new Note();
		note.setActive(true);
		note.setDescription(noteCreationRequest.getDescription());
		note.setTitle(noteCreationRequest.getTitle());
		note.setUserId(jwtUtils.extractUserId(token.replace("Bearer ", "")));

		final var savedNote = noteRepository.save(note);

		noteCreationRequest.getTags().forEach(noteTag -> {
			final var tag = tagRepository.findByName(noteTag.getName().toUpperCase()).orElse(new Tag());
			tag.setName(noteTag.getName().toUpperCase());
			final var savedTag = tagRepository.save(tag);

			final var noteTagMapping = new NoteTagMapping();
			noteTagMapping.setTagId(savedTag.getId());
			noteTagMapping.setNoteId(savedNote.getId());
			noteTagMappingRepository.save(noteTagMapping);
		});

		return responseUtils.noteSuccessResponse(savedNote.getId());
	}

	public ResponseEntity<?> update(final NoteUpdationRequestDto noteUpdationRequest, final String token) {
		final var note = noteRepository.findById(noteUpdationRequest.getId()).get();
		note.setActive(noteUpdationRequest.getIsActive());
		note.setDescription(noteUpdationRequest.getDescription());

		final var savedNote = noteRepository.save(note);

		noteUpdationRequest.getTags().forEach(noteTag -> {
			final var tag = tagRepository.findByName(noteTag.getName().toUpperCase()).orElse(new Tag());
			tag.setName(noteTag.getName().toUpperCase());
			final var savedTag = tagRepository.save(tag);

			final var noteTagMapping = noteTagMappingRepository
					.findByTagIdAndNoteId(savedTag.getId(), savedNote.getId()).orElse(new NoteTagMapping());
			noteTagMapping.setTagId(savedTag.getId());
			noteTagMapping.setNoteId(savedNote.getId());
			noteTagMappingRepository.save(noteTagMapping);
		});

		return responseUtils.noteSuccessResponse(savedNote.getId());
	}

	public ResponseEntity<?> retreive(final String token) {
		final var user = userRepository.findById(jwtUtils.extractUserId(token.replace("Bearer ", ""))).get();
		return ResponseEntity.ok(user.getNotes().parallelStream()
				.map(note -> NoteDto.builder().id(note.getId()).createdAt(note.getCreatedAt())
						.description(note.getDescription()).isActive(note.isActive()).title(note.getTitle())
						.updatedAt(note.getUpdatedAt()).build())
				.collect(Collectors.toList()));
	}

}
