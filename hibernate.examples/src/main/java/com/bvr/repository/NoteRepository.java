package com.bvr.repository;

import java.util.List;

import com.bvr.domain.Note;

public interface NoteRepository {
	List<Note> findAll();
}
