package com.dipu.dpms.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dipu.dpms.interceptor.LoginInterceptor;

/**
 * @ClassName: MvcConfiguration
 * @Description: MVC基础配置
 * @author WangPeng
 * @date 2016年1月6日 下午1:43:02
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.dipu.dpms"})
public class MvcConfiguration extends WebMvcConfigurerAdapter {

  @Autowired
  private LoginInterceptor loginInterceptor;
  @Autowired
  private ExceptionConfiguration myHandlerExceptionResolver;
  /**
   * 异步Web请求拦截器，通过{@link HibernateConfiguration} 里面的Bean(openSessionInViewInterceptor)得到
   */
  @Autowired
  private OpenSessionInViewInterceptor openSessionInViewInterceptor;

  /**
   * 添加web资源代理
   */
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**/*").addResourceLocations("/WEB-INF/res/");
  }

  /**
   * 配置拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addWebRequestInterceptor(openSessionInViewInterceptor);
    Collection<String> urlMapping = new ArrayList<String>();
    urlMapping.add("*.html");
    urlMapping.add("*.ajax");
    registry.addInterceptor(this.loginInterceptor).addPathPatterns(urlMapping.toArray(new String[] {}));
  }

  /**
   * 配置异常处理代理
   */
  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    exceptionResolvers.add(this.myHandlerExceptionResolver);
  }

  /**
   * 为了实现<welcome-file>index.jsp</welcome-file>的效果 设置项目默认首页
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("forward:/index.jsp");
    // registry.addViewController("error.html").setViewName("forward:/WEB-INF/views/error.jsp");
  }
}
