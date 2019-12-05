package com.ib.library.service.abstraction;

import com.ib.library.model.Work;
import java.util.List;

public interface WorkService {
  List<Work> findWorksByAuthorName(String authorName);
  Work findWorkByTitle(String title);
  Iterable<Work> findAllWorks();
}
