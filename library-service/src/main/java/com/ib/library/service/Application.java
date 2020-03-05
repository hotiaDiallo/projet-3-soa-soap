package com.ib.library.service;

import com.ib.library.model.Loan;
import com.ib.library.repository.*;
import com.ib.library.service.abstraction.*;
import com.ib.library.service.batch.LateLoan;
import com.ib.library.service.batch.MailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

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
  private LoanService loanService;
  @Autowired
  private LateLoan lateLoan;
  @Autowired
  private WorkService workService;
  @Autowired
  private BookService bookService;

  @Autowired
  private LibraryRepository libraryRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("##########################################################");
    List<Loan> loansByUser = lateLoan.findAllLateLoansByUser("ibraDiallo@gmail.com");
    lateLoan.sendEmail(MailConstants.FRIEND_EMAIL);
    System.out.println("##########################################################");

  }
}
