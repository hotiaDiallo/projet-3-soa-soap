package com.ib.library.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String ISBN;
  @ManyToOne(targetEntity = Work.class, fetch = FetchType.LAZY)
  private Work work;
  private boolean bookStatus;

  public Book() {
  }

  public Book(String ISBN, boolean bookStatus) {
    this.bookStatus = bookStatus;
    this.ISBN = ISBN;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public Work getWork() {
    return work;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public boolean getBookStatus() {
    return bookStatus;
  }

  public void setBookStatus(boolean bookStatus) {
    this.bookStatus = bookStatus;
  }
}
