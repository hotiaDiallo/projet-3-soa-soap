package com.ib.library.service.abstraction;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;

public interface WorkService {
  List<Work> findWorkByAuthor(Author author);
  Work findWorkByTitle(String title);
  Work findWorkByReleaseDate(Date releaseDate);
  Iterable<Work> findAllWorks();
}
