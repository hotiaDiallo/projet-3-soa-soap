package com.ib.library.repository;

import com.ib.library.model.Work;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WorkDao extends CrudRepository<Work, Integer> {

}