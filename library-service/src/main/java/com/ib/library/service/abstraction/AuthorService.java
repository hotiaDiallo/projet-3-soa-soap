package com.ib.library.service.abstraction;

import com.ib.library.model.Author;

public interface AuthorService {
  Author save (Author author);

  Author find(Integer id);

  Author findAuthorByName(String name);

}
