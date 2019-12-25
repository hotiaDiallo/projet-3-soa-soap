package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import com.ib.library.repository.WorkRepository;
import com.ib.library.service.abstraction.WorkService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkRepository workRepository;

  @Override
  public List<Work> findWorkByAuthor(Author author) {
    List<Work> works;
    works = workRepository.findWorkByAuthor(author);
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

  @Override
  public Iterable<Work> findAllWorks() {
      List<Work> works = new ArrayList<>(0);
      workRepository.findAll().iterator().forEachRemaining(works::add);
      return works;
  }
}
