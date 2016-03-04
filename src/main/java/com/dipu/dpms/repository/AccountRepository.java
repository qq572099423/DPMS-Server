package com.dipu.dpms.repository;

import com.dipu.dpms.entity.Account;



public interface AccountRepository {
  Account login(String username, String password);
}
