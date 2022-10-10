package com.bvr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bvr.domain.Note;


@Repository
public class JpaNoteRepository implements NoteRepository {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return this.entityManager.createQuery("SELECT t from Note t", Note.class).getResultList();
		
	}

}
