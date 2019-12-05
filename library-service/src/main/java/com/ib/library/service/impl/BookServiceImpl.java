package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.model.Book;
import com.ib.library.service.abstraction.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {


  @Override
  public List<Book> findAll() {
    return null;
  }

  @Override
  public Book find(int id) {
    return null;
  }

  @Override
  public Book createBook(Integer id, String bookName, Author author) {
    return null;
  }

  @Override
  public List<Book> findAllAvailableBook() {
    return null;
  }

  @Override
  public List<Book> findAllNotAvailableBook() {
    return null;
  }

  @Override
  public List<Book> findAllByName(String name) {
    return null;
  }
}
