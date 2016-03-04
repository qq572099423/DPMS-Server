package com.dipu.dpms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	@RequestMapping(value = "/error.html",method = RequestMethod.GET)
	public ModelAndView page(){
		return new ModelAndView("/error");
	}
}
