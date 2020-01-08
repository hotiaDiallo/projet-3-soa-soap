package com.ib.library.service.abstraction;

import com.ib.library.model.User;
import java.util.List;

public interface UserService {
  User login(String email, String password);

  List<User> findAll();

  User findUserById(Integer userId);
}
