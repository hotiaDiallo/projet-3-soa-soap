package com.ib.library.service.abstraction;

import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import java.util.List;

public interface LoanService {

  Loan findLoanById(Integer id);

  String createLoan(Integer workId, Integer userId);

  List<Loan> findLoanByUser(Integer userId);

  void returnLoan(Integer loanId);
  void extendLoan(Integer loanId);

  List<Loan> findAllLoans();
}
