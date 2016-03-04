package com.dipu.dpms.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dipu.dpms.entity.Account;
import com.dipu.dpms.repository.AccountRepository;

@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {
  @Autowired
  private SessionFactory sessionFactory;

  /**
   * 通过用户名和密码查询账号记录
   */
  @Override
  public Account login(String username, String password) {
    Session session = sessionFactory.getCurrentSession();
    @SuppressWarnings("unchecked")
    List<Account> list = session.createQuery("select u from Account u where u.username=:username and u.password=:password")
    .setString("username", username)
    .setString("password", password)
    .list();
    if (list == null || list.size() == 0) {
      return null;
    } else {
      return list.get(0);
    }
  }


}
