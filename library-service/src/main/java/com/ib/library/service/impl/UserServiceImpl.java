package com.ib.library.service.impl;

import com.ib.library.model.User;
import com.ib.library.repository.UserRepository;
import com.ib.library.service.abstraction.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  /**
   *
   * @param email
   * @param password
   * @return
   */

  @Override
  public User login(String email, String password) {
    User user = null;
    Optional<User> existingUser = userRepository.findByEmailAndPassword(email, password);
    if (existingUser.isPresent()) {
      user = existingUser.get();
    } else {
      /**
       * Faudra penser à mettre en place une exception
       */
      System.out.println("User does not exist");
      user = null;
    }
    return user;
  }

  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public User findUserById(Integer id) {
    return userRepository.findById(id).get();
  }
}
