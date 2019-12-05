package com.ib.library.service.abstraction;

import com.ib.library.model.Book;
import com.ib.library.model.Loan;
import com.ib.library.model.User;
import java.util.Date;
import java.util.List;

public interface LoanService {
  Loan find(int id);

  Loan create(User usager, Book book, Date startDate, Date endDate);

  List<Loan> findall();

  List<Loan> findAllByUsager(User user);

}
