package com.ib.library.service.abstraction;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;

public interface WorkService {
  Work findWorkById(Integer id);

  List<Work> findWorkByAuthor(Author author);
  Work findWorkByAuthorAndReleaseDate(Author author, Date releaseDate);

  Work findWorkByTitle(String title);
  Work findWorkByReleaseDate(Date releaseDate);
}
