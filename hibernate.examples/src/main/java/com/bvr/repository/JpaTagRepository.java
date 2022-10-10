package com.bvr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bvr.domain.Tag;

@Repository
public class JpaTagRepository implements TagRepository {

	@PersistenceContext 
	private EntityManager entityManager;
	
	
	@Override
	public List<Tag> findAll() {
		// TODO Auto-generated method stub
		return this.entityManager.createQuery("SELECT t from Tag t", Tag.class).getResultList();
	}

}
