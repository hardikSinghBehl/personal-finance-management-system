package com.hardik.plutocracy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.constant.ContextType;
import com.hardik.plutocracy.dto.response.TagRetreivalRequestDto;
import com.hardik.plutocracy.entity.Tag;
import com.hardik.plutocracy.repository.NoteTagMappingRepository;
import com.hardik.plutocracy.repository.TagRepository;
import com.hardik.plutocracy.repository.TicketTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagService {

	private final TagRepository tagRepository;

	private final NoteTagMappingRepository noteTagMappingRepository;

	private final TicketTagMappingRepository ticketTagMappingRepository;

	public List<Tag> retreiveAll() {
		return tagRepository.findAll();
	}

	public ResponseEntity<List<String>> retreive(final TagRetreivalRequestDto tagRetreivalRequest, final String token) {
		if (tagRetreivalRequest.getContextType().equalsIgnoreCase(ContextType.NOTE.getName())) {
			return ResponseEntity
					.ok(noteTagMappingRepository.findByNoteId(tagRetreivalRequest.getContextId()).parallelStream()
							.map(noteTagMapping -> noteTagMapping.getTag().getName()).collect(Collectors.toList()));
		}
		if (tagRetreivalRequest.getContextType().equalsIgnoreCase(ContextType.COMPLETED_TICKET.getName())
				|| tagRetreivalRequest.getContextType().equalsIgnoreCase(ContextType.FUTURE_TICKET.getName()))
			return ResponseEntity
					.ok(ticketTagMappingRepository.findByTicketId(tagRetreivalRequest.getContextId()).parallelStream()
							.map(ticketTagMapping -> ticketTagMapping.getTag().getName()).collect(Collectors.toList()));
		return ResponseEntity.badRequest().build();

	}

}
