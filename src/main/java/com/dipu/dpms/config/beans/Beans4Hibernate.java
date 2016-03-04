package com.dipu.dpms.config.beans;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dipu.dpms.config.DBInitializer;

/**
 * @ClassName: HibernateConfiguration
 * @Description: (Hibernate配置)
 * @author WangPeng
 * @date 2016年1月6日 上午10:58:59
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dipu.dpms"})
public class Beans4Hibernate {

  @Autowired
  private DataSource dataSource;

  /**
   * @Title: sessionFactory
   * @Description: (Hibernate会话工厂配置)
   * @param 
   * @return LocalSessionFactoryBean
   * @throws
   */
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    // 设置数据源
    sessionFactory.setDataSource(dataSource);
    // 扫描实体类所在的包
    sessionFactory.setPackagesToScan(new String[] {"com.dipu.dpms.entity"});
    // 一些额外配置
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.globally_quoted_identifiers", "true");
    properties.setProperty("hibernate.autoReconnect", "true");
    properties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
    properties.setProperty("hibernate.cache.use_second_level_cache", "true");
    properties.setProperty("hibernate.cache.use_query_cache", "true");
    properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
    properties.setProperty("net.sf.ehcache.configurationResourceName", "/cache-config.xml");
    sessionFactory.setHibernateProperties(properties);
    
    return sessionFactory;
  }

  /**
   * @Title: transactionManager
   * @Description: (配置事物管理)
   * @param  sessionFactory
   * @return PlatformTransactionManager
   * @throws
   */
  @Bean
  public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);
    return txManager;
  }

  /**
   * @Title: openSessionInViewInterceptor
   * @Description: TODO(异步Web请求拦截器)
   * @param sessionFactory
   * @return OpenSessionInViewInterceptor
   * @throws
   */
  @Bean
  public OpenSessionInViewInterceptor openSessionInViewInterceptor(SessionFactory sessionFactory) {
    OpenSessionInViewInterceptor interceptor = new OpenSessionInViewInterceptor();
    interceptor.setSessionFactory(sessionFactory);
    return interceptor;
  }

  /**
   * @Title: setupData
   * @Description: (数据库初始化Bean)
   * @param 
   * @return DBInitializer
   * @throws
   */
  @Bean(initMethod = "initDB")
  public DBInitializer setupData() {
    return new DBInitializer();
  }
}
