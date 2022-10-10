package com.bvr.repository;

import java.util.List;

import com.bvr.domain.Tag;

public interface TagRepository {

	List<Tag> findAll();
}
