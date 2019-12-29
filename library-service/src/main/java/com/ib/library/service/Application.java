package com.ib.library.service;

import com.ib.library.model.Author;
import com.ib.library.model.Book;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.repository.AuthorRepository;
import com.ib.library.repository.BookRepository;
import com.ib.library.repository.LoanRepository;
import com.ib.library.repository.UserRepository;
import com.ib.library.repository.WorkRepository;
import com.ib.library.service.abstraction.BookService;
import com.ib.library.service.abstraction.UserService;
import com.ib.library.service.abstraction.WorkService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ib.library"})
@EntityScan(basePackages = {"com.ib.library"})
@ComponentScan(basePackages = {"com.ib.library.service", "com.ib.library.repository"})
public class Application implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private WorkRepository workRepository;
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private LoanRepository loanRepository;

  @Autowired
  private UserService userService;
  @Autowired
  private WorkService workService;
  @Autowired
  private BookService bookService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    DateFormat def = new SimpleDateFormat("dd/MM/yyy");

    System.out.println("AUTHORS");
    authorRepository.findAll().forEach(author->System.out.println(author));
    Author author = authorRepository.findById(1).get();

    System.out.println("BOOKS");
    bookRepository.findAll().forEach(book->System.out.println(book));

    System.out.println("WORKS");
    workRepository.findAll().forEach(work->System.out.println(work));

    System.out.println("USERS");
    userRepository.findAll().forEach(user->System.out.println(user));

    System.out.println("LOANS");
    loanRepository.findAll().forEach(loan->System.out.println(loan));


    System.out.println("IS LOANABLE");
    Work work1 = workService.findWorkByTitle("title1");
    Work work3 = workService.findWorkByTitle("title3");
    if (work1.isLoanable()) {
      System.out.println("Cette oeuvre est disponible");
    } else {
      System.out.println("Non disponible");
    }

    if (work3.isLoanable()) {
      System.out.println("Cette oeuvre est disponible");
    } else {
      System.out.println("Non disponible");
    }

    System.out.println("Listes des works par author");
    List<Work> works = workService.findWorkByAuthor(author);
    for (Work work: works) {
      System.out.println(author.getFirstName()+":"+work.getTitle());
    }


  }
}
