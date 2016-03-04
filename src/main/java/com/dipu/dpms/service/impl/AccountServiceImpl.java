package com.dipu.dpms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipu.dpms.entity.Account;
import com.dipu.dpms.repository.AccountRepository;
import com.dipu.dpms.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
 
  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Account login(String username, String password) {
    return accountRepository.login(username, password);
  }

}
