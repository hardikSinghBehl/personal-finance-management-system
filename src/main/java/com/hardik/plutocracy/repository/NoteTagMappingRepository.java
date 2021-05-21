package com.hardik.plutocracy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.plutocracy.entity.NoteTagMapping;

@Repository
public interface NoteTagMappingRepository extends JpaRepository<NoteTagMapping, Integer> {

}
