package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import com.ib.library.repository.WorkRepository;
import com.ib.library.service.abstraction.WorkService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkRepository workRepository;

  @Override
  public Work findWorkById(Integer id) {
    return workRepository.findById(id).get();
  }

  @Override
  public Work findWorkByAuthorAndReleaseDate(Author author, Date releaseDate) {
    return workRepository.findWorkByAuthorAndReleaseDate(author, releaseDate);
  }

  @Override
  public List<Work> findWorkByAuthor(Author author) {
    List<Work> works = workRepository.findWorkByAuthor(author);
    return works;
  }

  @Override
  public Work findWorkByTitle(String title) {
    return workRepository.findWorkByTitle(title);
  }

  @Override
  public Work findWorkByReleaseDate(Date releaseDate) {
    return workRepository.findByReleaseDate(releaseDate);
  }

}
