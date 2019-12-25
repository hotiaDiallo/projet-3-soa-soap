package com.ib.library.service.abstraction;

import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LoanService {

  Loan findLoan(Integer id);

  Loan createLoan(Work work, User user, Date borrowingDate, Date returningDate);

  List<Loan> findLoanByUser(User user);

  void returnLoan(Loan loan);
  void extendLoan(Loan loan);

  List<Loan> findAllLoans();
}
