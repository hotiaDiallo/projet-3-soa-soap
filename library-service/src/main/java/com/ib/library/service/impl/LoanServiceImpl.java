package com.ib.library.service.impl;

import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.repository.LoanRepository;
import com.ib.library.service.abstraction.LoanService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

  @Autowired
  private LoanRepository loanRepository;

  @Override
  public Loan findLoan(Integer id) {
    return null;
  }

  @Override
  public Loan createLoan(Work work, User user, Date borrowingDate, Date returningDate) {
    return null;
  }

  @Override
  public List<Loan> findLoanByUser(User user) {
    return null;
  }

  @Override
  public void returnLoan(Loan loan) {

  }

  @Override
  public void extendLoan(Loan loan) {

  }

  @Override
  public List<Loan> findAllLoans() {
    return null;
  }
}
