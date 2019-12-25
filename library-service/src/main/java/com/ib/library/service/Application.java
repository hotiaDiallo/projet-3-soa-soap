package com.ib.library.service;

import com.ib.library.model.Author;
import com.ib.library.model.Book;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.repository.AuthorRepository;
import com.ib.library.repository.BookRepository;
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

    /* USER CREATION*/
    User user1 = new User("john", "Doe", "john1@gmail.com", "1234");
    User user2 = new User("john", "Doe", "john2@gmail.com", "1234");
    User user3 = new User("john", "Doe", "john3@gmail.com", "1234");
    User user4 = new User("john", "Doe", "john4@gmail.com", "1234");
    User user5 = new User("Ibrahima", "Diallo", "ibra@gmail.com", "1234");
    userRepository.save(user1);
    userRepository.save(user2);
    userRepository.save(user3);
    userRepository.save(user4);
    userRepository.save(user5);
    //userRepository.findAll().forEach(p->System.out.println(p.getEmail()));


    /* WORK CREATION*/
    Work work1 = new Work("title1", def.parse("12/10/1992"), "resume1");
    Work work2 = new Work("title2", def.parse("06/01/2000"), "resume2");
    Work work3 = new Work("title3", def.parse("10/10/2010"), "resume3");

    /* BOOK CREATION*/
    Book book1 = new Book("ISBN1", false);
    Book book2 = new Book("ISBN2", false);
    Book book3 = new Book("ISBN3", true);
    Book book4 = new Book("ISBN4", true);

    bookRepository.save(book1);
    bookRepository.save(book2);
    bookRepository.save(book3);
    bookRepository.save(book4);



    work1.getBooks().add(book1);
    work1.getBooks().add(book2);
    work1.getBooks().add(book3);
    workRepository.save(work1);
    workRepository.save(work2);
    workRepository.save(work3);

    Author author1 = new Author("John", "Doe");

    System.out.println("################ TEST WORK SERVICE ###############");
    System.out.println("Find by Title");
    System.out.println(workService.findWorkByTitle("title1").getReleaseDate());
    System.out.println("Find by Release Date");
    System.out.println(workService.findWorkByReleaseDate(def.parse("06/01/2000")).getTitle());

    System.out.println("IS LOANABLE");
    System.out.println(workService.findWorkByTitle("title1").isLoanable());


    System.out.println("################ ALL WORKS ###############");
    List<Work> works = (List<Work>) workService.findAllWorks();
    for (Work work: works) {
      System.out.println(work.getTitle());
    }


  }
}
