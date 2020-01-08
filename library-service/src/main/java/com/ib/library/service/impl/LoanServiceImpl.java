package com.ib.library.service.impl;

import com.ib.library.model.Book;
import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.repository.BookRepository;
import com.ib.library.repository.LoanRepository;
import com.ib.library.service.Utils.Status;
import com.ib.library.service.abstraction.LoanService;
import com.ib.library.service.abstraction.UserService;
import com.ib.library.service.abstraction.WorkService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

  @Autowired
  private LoanRepository loanRepository;

  @Autowired
  private UserService userService;
  @Autowired
  BookRepository bookRepository;
  @Autowired
  private WorkService workService;

  @Override
  public Loan findLoanById(Integer id) {
    return loanRepository.findById(id).get();
  }

  @Override
  public String createLoan(Integer workId, Integer userId) {
    User user = userService.findUserById(userId);
    Work work = workService.findWorkById(workId);
    if (work.isLoanable()){
      Loan loan = new Loan();
      Calendar calendar = Calendar.getInstance();
      Date borrowingDate = calendar.getTime();
      calendar.add(calendar.MONTH,1);
      Date returningDate = calendar.getTime();
      loan.setUser(user);
      Book book = work.getAvailableBook(work.getBooks());
      loan.setBook(book);
      loan.setBorrowingDate(borrowingDate);
      loan.setReturningDate(returningDate);
      loan.setLoanStatus(Status.STATUS_LOAN_ACTIVATED);
      loanRepository.save(loan);
      book.setBookStatus(false);
      bookRepository.save(book);
      return "Success : loan created";
    }else{
      return "Error : Something went wrong";
    }
  }


  @Override
  public List<Loan> findLoanByUser(Integer userId) {
    return loanRepository.findLoanByUserId(userId);
  }

  @Override
  public void returnLoan(Integer loanId) {
    Loan loan = findLoanById(loanId);
    loan.setLoanStatus(Status.STATUS_LOAN_RETURNED);
    loanRepository.save(loan);
    Book book = loan.getBook();
    book.setBookStatus(true);
    bookRepository.save(book);
  }

  @Override
  public void extendLoan(Integer loanId) {
    Loan loan = findLoanById(loanId);
    Date returningDate = loan.getReturningDate();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(returningDate);
    calendar.add(calendar.MONTH,1);
    Date returningDateAfterLoanExtended = calendar.getTime();
    loan.setReturningDate(returningDateAfterLoanExtended);
    loan.setLoanStatus(Status.STATUS_LOAN_EXTENDED);
    loanRepository.save(loan);
  }

  @Override
  public List<Loan> findAllLoans() {
    return (List<Loan>) loanRepository.findAll();
  }
}
