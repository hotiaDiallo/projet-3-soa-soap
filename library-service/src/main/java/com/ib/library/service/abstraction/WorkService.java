package com.ib.library.service.abstraction;

import com.ib.library.model.Work;
import java.util.List;

public interface WorkService {
  Iterable<Work> findAllWorks();
}
