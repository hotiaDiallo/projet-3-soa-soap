package com.ib.library.service.impl;

import com.ib.library.model.Book;
import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.service.abstraction.LoanService;
import java.util.Date;
import java.util.List;

public class LoanServiceImpl implements LoanService {


  @Override
  public Loan find(int id) {
    return null;
  }

  @Override
  public Loan create(User usager, Book book, Date startDate, Date endDate) {
    return null;
  }

  @Override
  public List<Loan> findall() {
    return null;
  }

  @Override
  public List<Loan> findAllByUsager(User user) {
    return null;
  }
}
