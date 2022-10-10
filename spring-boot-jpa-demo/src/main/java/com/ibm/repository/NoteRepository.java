package com.ibm.repository;

import java.util.List;

import com.ibm.domain.Note;

public interface NoteRepository {

	 List<Note> findAll();
}
