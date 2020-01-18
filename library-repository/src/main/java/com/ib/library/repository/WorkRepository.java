package com.ib.library.repository;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Integer> {
  Work findWorkByTitle(String title);
  Work findWorkByReleaseDate(Date releaseDate);
  List<Work> findWorkByAuthor(Author author);
  Work findWorkByAuthorAndReleaseDate(Author author, Date releaseDate);

//  @Query("SELECT * from work w WHERE w.author_id = :id")
//  List<Work> findWorkByAuthorId(@Param("id") Integer id);
//  Work findByReleaseDate(Date releaseDate);
//  @Query("SELECT * from work w WHERE w.author_id = :id and release_date = :releaseDate")
//  Work findWorkByAuthorIdAndReleaseDate(@Param("id") Integer id, @Param("releaseDate") Date releaseDate);
}
