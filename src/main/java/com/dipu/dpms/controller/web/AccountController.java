package com.dipu.dpms.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dipu.dpms.entity.Account;
import com.dipu.dpms.service.AccountService;
import com.dipu.dpms.service.CommonService;
import com.dipu.dpms.util.CommonUtil;
import com.dipu.dpms.util.Constant;
import com.dipu.dpms.util.MessageSourceUtil;
import com.dipu.dpms.util.ResultMap;
import com.dipu.dpms.util.ValidateUtil;

@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountService accountService;
  @Autowired
  private CommonService commonService;

  @RequestMapping(value = "/login.ajax")
  public @ResponseBody ResultMap login(String username, String password, HttpSession session) throws Exception {
    ResultMap map = new ResultMap();
    Account a = new Account();
    a.setId(10L);
    a.setName("wp");
    a.setCellphone("13232457898");
    a.setEmail("wqeq@qq.com");
    a.setPassword("1214");
    a.setUsername("admin");
    commonService.save(a);
    // 验证用户名是否为空
    if (ValidateUtil.isEmpty(username, "ACCOUNT.USERNAME", map)) {
      return map;
    }
    // 验证用密码是否为空
    if (ValidateUtil.isEmpty(password, "ACCOUNT.PASSWORD", map)) {
      return map;
    }
    // 对密码进行MD5加密
    password = CommonUtil.getMd5(password);

    Account acc = accountService.login(username, password);
    if (acc == null) {
      map.setMessage(MessageSourceUtil.loadMesage("MSG.LOGIN.FAILED"));
      return map;
    }

    session.setAttribute(Constant.Attribute.LOGIN, acc);

    map.setHasSuccess(true);

    return map;
  }

}
