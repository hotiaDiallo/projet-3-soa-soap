package com.ib.library.repository;

import com.ib.library.model.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanDao extends CrudRepository<Loan, Integer> {

}