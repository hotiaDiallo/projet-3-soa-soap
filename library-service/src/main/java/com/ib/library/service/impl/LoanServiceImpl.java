package com.ib.library.service.impl;

import com.ib.library.model.Loan;
import com.ib.library.repository.LoanRepository;
import com.ib.library.service.abstraction.LoanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanServiceImpl implements LoanService {

  @Autowired
  private LoanRepository loanRepository;

  @Override
  public List<Loan> findAllLoans() {
    return (List<Loan>) loanRepository.findAll();
  }

  @Override
  public List<Loan> findLoanByUser(Integer id) {
    return (List<Loan>) loanRepository.findAllById(id);
  }

  @Override
  public Optional<Loan> findLoanByBook(Integer id) {
    return loanRepository.findById(id);
  }
}
