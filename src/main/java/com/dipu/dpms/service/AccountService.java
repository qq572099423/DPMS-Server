package com.dipu.dpms.service;

import com.dipu.dpms.entity.Account;

public interface AccountService {
  Account login(String username, String password);
}
