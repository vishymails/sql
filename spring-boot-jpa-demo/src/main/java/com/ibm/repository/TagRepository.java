package com.ibm.repository;

import java.util.List;

import com.ibm.domain.Tag;

public interface TagRepository {

	 List<Tag> findAll();
}
