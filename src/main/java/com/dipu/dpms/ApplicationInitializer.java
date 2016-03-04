package com.dipu.dpms;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.dipu.dpms.config.MvcConfiguration;
import com.dipu.dpms.config.SecurityConfig;
import com.dipu.dpms.config.beans.Beans4Custom;
import com.dipu.dpms.config.beans.Beans4Hibernate;
import com.dipu.dpms.config.beans.Beans4ViewResolver;

/**
 * @ClassName: ApplicationInitializer
 * @Description: (初始化Web项目，作用类似web.xml)
 * @author WangPeng
 * @date 2016年1月6日 上午10:21:01
 */
public class ApplicationInitializer implements WebApplicationInitializer {
  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

  /**
   * 最大允许上传的Size为5MB
   */
  private static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 5;
  /**
   * 允许multipart/form-data请求的最大Size为1MB
   */
  private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;
  /**
   * 无请求大小限制
   */
  private static final long MAX_REQUEST_SIZE = -1L;

  /**
   * 程序启动入口
   */
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    //registerFilter(servletContext);
    registerListener(servletContext);
    registerDispatcherServlet(servletContext);
  }

  private void registerFilter(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext webContext = createContext(SecurityConfig.class);

    Dynamic dynamic = servletContext.addFilter("scurityFilter", new DelegatingFilterProxy(null, webContext));
    dynamic.addMappingForUrlPatterns(null, true, "*.app");
  }

  /**
   * @Title: registerListener
   * @Description: (注册Context listener，初始化Hibernate)
   * @param servletContext
   * @return void
   * @throws
   */
  private void registerListener(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext rootContext = createContext(Beans4Hibernate.class, Beans4ViewResolver.class, Beans4Custom.class);
    servletContext.addListener(new ContextLoaderListener(rootContext));

  }

  /**
   * @Title: registerDispatcherServlet
   * @Description: (注册Spring MVC)
   * @param servletContext
   * @return void
   * @throws
   */
  private void registerDispatcherServlet(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext dispatcherContext = createContext(MvcConfiguration.class,SecurityConfig.class);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherContext));
    dispatcher.setLoadOnStartup(1);
    // dispatcher.addMapping("*.ajax");
    dispatcher.addMapping("/");
    dispatcher.setMultipartConfig(new MultipartConfigElement(null, MAX_FILE_UPLOAD_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
  }

  /**
   * @Title: createContext
   * @Description: (获得给予注解的ApplicationContext)
   * @param annotatedClasses
   * @return AnnotationConfigWebApplicationContext
   * @throws
   */
  private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(annotatedClasses);
    return context;
  }
}
