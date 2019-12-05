package com.ib.library.repository;


import com.ib.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {
}