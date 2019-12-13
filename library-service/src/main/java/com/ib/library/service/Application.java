package com.ib.library.service;

import com.ib.library.model.User;
import com.ib.library.repository.UserRepository;
import com.ib.library.service.abstraction.UserService;
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
  private UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userRepository.save(new User("john", "Doe", "john1@gmail.com", "1234"));
    userRepository.save(new User("john", "Doe", "john2@gmail.com", "1234"));
    userRepository.save(new User("john", "Doe", "john3@gmail.com", "1234"));
    userRepository.save(new User("john", "Doe", "john4@gmail.com", "1234"));
    userRepository.save(new User("Ibrahima", "Diallo", "ibra@gmail.com", "1234"));
    userRepository.findAll().forEach(p->System.out.println(p.getEmail()));

    System.out.println(
        userService.login("ibra@gmail.com", "1234").getFirstName());
  }
}
