package com.ib.library.service.abstraction;

import com.ib.library.model.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanService {

  List<Loan> findAllLoans();

  List<Loan> findLoanByUser(Integer id);

  Optional<Loan> findLoanByBook(Integer id);
}
