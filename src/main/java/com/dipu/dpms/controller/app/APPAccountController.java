package com.dipu.dpms.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dipu.dpms.entity.Account;
import com.dipu.dpms.model.app.BaseModel;
import com.dipu.dpms.service.AccountService;

@Controller
@RequestMapping("/account")
public class APPAccountController {
  @Autowired
  private AccountService accountService;
  @RequestMapping(value = "/login.app")
  public @ResponseBody BaseModel<Account> login(String username,String password) {
    BaseModel<Account> result = new BaseModel<Account>();
    try {
      Account acc = accountService.login(username, password);
      if(null != acc){
        acc.setPassword(null);
      }
      result.setData(acc);
      result.setSuccess(true);
    } catch (Exception e) {
      result.setErrMsg(e.getMessage());
    }
    return result;
  }
  @RequestMapping(value = "/test.app")
  public @ResponseBody String page() {
    return "hahaha";
  }
}
