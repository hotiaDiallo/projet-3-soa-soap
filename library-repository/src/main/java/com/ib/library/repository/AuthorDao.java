package com.ib.library.repository;

import com.ib.library.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Integer> {
}