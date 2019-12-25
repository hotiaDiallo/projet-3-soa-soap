package com.ib.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "work")
public class Work implements Serializable {
  @Id
  @Column(name = "id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  private String resume;
  private Date releaseDate;

  @ManyToOne(fetch = FetchType.LAZY)
  private Author author;
  @OneToMany(mappedBy = "work", fetch = FetchType.EAGER)
  private List<Book> books = new ArrayList<>();

  public Work() {
  }

  public Work(String title, Date releaseDate, String resume) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.resume = resume;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isLoanable(){
    boolean status = false;
    for(Book book : books){
      if(book.getBookStatus()==true){
        status = true;
        break;
      }else{
        continue;
      }
    }
    return status;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
