package com.ib.library.repository;

import com.ib.library.model.Loan;
import com.ib.library.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
  List<Loan> findLoanByUserId(Integer id);
}