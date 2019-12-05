package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.repository.AuthorDao;
import com.ib.library.service.abstraction.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceImpl implements AuthorService {

  @Autowired
  private AuthorDao authorDao;


  @Override
  public Author save(Author author) {
    return new Author("John","Doe");
  }

  @Override
  public Author find(Integer id) {
    return null;
  }

  @Override
  public Author findAuthorByName(String name) {
    return null;
  }
}
