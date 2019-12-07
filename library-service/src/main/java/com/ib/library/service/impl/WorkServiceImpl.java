package com.ib.library.service.impl;

import com.ib.library.model.Work;
import com.ib.library.repository.WorkRepository;
import com.ib.library.service.abstraction.WorkService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkRepository workRepository;

  @Override
  public Iterable<Work> findAllWorks() {
      List<Work> works = new ArrayList<>(0);
      workRepository.findAll().iterator().forEachRemaining(works::add);
      return works;
  }
}
