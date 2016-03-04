package com.dipu.dpms.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dipu.dpms.entity.Account;
import com.dipu.dpms.util.CommonUtil;
import com.dipu.dpms.util.Constant;
import com.dipu.dpms.util.MessageSourceUtil;

/**
 * 
 * @ClassName: LoginInterceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author WangPeng
 * @date 2016年1月6日 上午10:54:35
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    String requestUrl = request.getRequestURI();
    requestUrl = requestUrl.split(";")[0];

    if (requestUrl == null && "".equals(requestUrl)) {
      throw new Exception("MSG.WARNING.URL.LLLEGAL");
    }
    String[] strArr = requestUrl.split("/");
    String endUrl = strArr[strArr.length - 1];
    
    
    
    if("login.ajax".equals(endUrl) || "DPMS".equals(endUrl)){
      return true;
    }
    
    HttpSession session = request.getSession();
    Account account = (Account) session.getAttribute(Constant.Attribute.LOGIN);
    if (account != null){
      return true;
    }
    if(CommonUtil.isAjax(request)){
      throw new Exception(MessageSourceUtil.loadMesage("MSG.LOGIN.EXPIRED"));
    }else{
      request.getRequestDispatcher("/").forward(request, response);
      return false;
    }
    
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }


}
