package com.ib.library.service.abstraction;

import com.ib.library.model.User;
import java.util.List;

public interface UserService {

  User createUser(String email);
  User find(int id);
  User findByEmail(String email);
  List<User> findAll();

}
