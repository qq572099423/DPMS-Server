package com.dipu.dpms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

  @RequestMapping("/home.html")
  public void page() {}
}
