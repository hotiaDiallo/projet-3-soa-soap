package com.ib.library.service.abstraction;

import com.ib.library.model.Author;
import com.ib.library.model.Book;
import java.util.List;

public interface BookService {
  List<Book> findAll();

  Book find(int id);

  Book createBook(Integer id, String bookName, Author author);

  List<Book> findAllAvailableBook();

  List<Book> findAllNotAvailableBook();

  List<Book> findAllByName(String name);

}
