package com.ib.library.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  private User user;
  @OneToOne(targetEntity = Work.class, fetch = FetchType.LAZY)
  private Work work;
  //@Column(name = "borrowing_date")
  private Date borrowingDate;
  //@Column(name = "return_date")
  private Date returnDate;
  //@Column(name = "loan_extended")
  private String loanStatus;

  public Loan(){
  }

  public Loan(User user, Work work, Date borrowingDate, Date returnDate, String loanExtended) {
    this.user = user;
    this.work = work;
    this.borrowingDate = borrowingDate;
    this.returnDate = returnDate;
    this.loanStatus = loanStatus;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Work getWork() {
    return work;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public Date getBorrowingDate() {
    return borrowingDate;
  }

  public void setBorrowingDate(Date borrowingDate) {
    this.borrowingDate = borrowingDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  public String getLoanStatus() {
    return loanStatus;
  }

  public void setLoanStatus(String loanStatus) {
    this.loanStatus = loanStatus;
  }
}
