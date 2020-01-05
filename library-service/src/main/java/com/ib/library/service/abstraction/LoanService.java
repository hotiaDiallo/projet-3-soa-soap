package com.ib.library.service.abstraction;

import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import java.util.List;

public interface LoanService {

  Loan findLoanById(Integer id);

  String createLoan(Integer workId, User user);

  List<Loan> findLoanByUser(User user);

  void returnLoan(Loan loan);
  void extendLoan(Loan loan);

  List<Loan> findAllLoans();
}
