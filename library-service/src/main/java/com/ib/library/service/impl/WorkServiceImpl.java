package com.ib.library.service.impl;

import com.ib.library.model.Work;
import com.ib.library.repository.WorkDao;
import com.ib.library.service.abstraction.WorkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkDao workDao;

  @Override
  public List<Work> findWorksByAuthorName(String authorName) {
    return null;
  }

  @Override
  public Work findWorkByTitle(String title) {
    return null;
  }

  @Override
  public Iterable<Work> findAllWorks() {
    return null;
  }
}
