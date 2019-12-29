package com.ib.library.repository;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Integer> {
  Work findWorkByTitle(String title);
  List<Work> findWorkByAuthor(Author author);
  Work findByReleaseDate(Date releaseDate);
}
