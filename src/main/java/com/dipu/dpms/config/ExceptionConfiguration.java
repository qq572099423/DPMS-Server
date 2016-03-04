package com.dipu.dpms.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.dipu.dpms.util.CommonUtil;
import com.dipu.dpms.util.MessageSourceUtil;

/**
 * @ClassName: ExceptionConfiguration
 * @Description: (异常处理代理)
 * @author WangPeng
 * @date 2016年1月6日 下午3:37:36
 */
public class ExceptionConfiguration extends DefaultHandlerExceptionResolver {
  private Properties exceptionMappings = new Properties();

  Map<String, Object> model = new HashMap<String, Object>();

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
    if (CommonUtil.isAjax(request)) {      
      response.setStatus(500);
      response.setCharacterEncoding("UTF-8");
      StringBuilder messgae = new StringBuilder();
      if (exception instanceof BindException) {
        BindException ex = (BindException) exception;
        for (ObjectError error : ex.getAllErrors()) {
          if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            String type = fieldError.getCodes()[0].split("\\.")[0].toUpperCase();
            String code;
            String fieldName = fieldError.getObjectName() + "." + fieldError.getField();
            switch (type) {
              case "NOTEMPTY":
              case "NOTNULL":
              case "EMAIL":
                code = "VALIDATE." + type;
                messgae.append(MessageSourceUtil.loadMesage(code, MessageSourceUtil.loadMesage(fieldName.toUpperCase())));
                break;
              case "SIZE":
                int start = Integer.parseInt(fieldError.getArguments()[1].toString());
                int end = Integer.parseInt(fieldError.getArguments()[2].toString());
                if (start == end) {
                  code = "VALIDATE." + type + ".EQUAL";
                  messgae.append(MessageSourceUtil.loadMesage(code, MessageSourceUtil.loadMesage(fieldName.toUpperCase()), start));
                } else {
                  code = "VALIDATE." + type + ".BETWEEN";
                  messgae.append(MessageSourceUtil.loadMesage(code, MessageSourceUtil.loadMesage(fieldName.toUpperCase()), end, start));
                }
                break;
              default:
                break;
            }
          }
        }
      } else {
        messgae.append(exception.getMessage());
      }

      PrintWriter writer = null;
      try {
        writer = response.getWriter();
        writer.write(messgae.toString());
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (writer != null) {
          writer.close();
        }
      }
      return null;
    } else {
      ModelMap model = new ModelMap();
      StringBuilder sb = new StringBuilder();
      sb.append("<ul><li>");
      sb.append(exception.getClass().getSimpleName());
      sb.append("</li><li>");
      sb.append(exception.getMessage());
      sb.append("</li><li>");
      sb.append("若情况紧急，请联系管理员解决");
      sb.append("</li></ul>");
      model.put("error", sb.toString());
      return new ModelAndView("/error", model);
    }

  }

  public Properties getExceptionMappings() {
    return exceptionMappings;
  }

  public void setExceptionMappings(Properties exceptionMappings) {
    this.exceptionMappings = exceptionMappings;
  }
}
