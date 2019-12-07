package com.ib.library.service.abstraction;

import com.ib.library.model.User;

public interface UserService {
  User login(String email, String password);
}
