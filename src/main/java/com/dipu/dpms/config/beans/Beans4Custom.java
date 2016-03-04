package com.dipu.dpms.config.beans;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import com.dipu.dpms.config.ExceptionConfiguration;
import com.dipu.dpms.interceptor.LoginInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @ClassName: Beans4Custom
 * @Description: (用户业务Bean定义)
 * @author WangPeng
 * @date 2016年1月6日 下午3:32:04
 */
@Configuration
@ComponentScan(basePackages = { "com.dipu.dpms" })
public class Beans4Custom {

	private MessageSource messageSource;

	/**
	 * @Title: dataSource
	 * @Description: (数据库连接配置)
	 * @param
	 * @return DataSource
	 * @throws
	 */
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		try {
			datasource.setDriverClass("com.mysql.jdbc.Driver");
			datasource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
			datasource.setUser("dipu");
			datasource.setPassword("34080995");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		datasource.setMaxPoolSize(40);
		datasource.setMinPoolSize(2);
		datasource.setMaxStatements(50);
		return datasource;
	}

	/**
	 * @Title: tilesConfigurer
	 * @Description: (初始化Tiles配置文件路径)
	 * @param
	 * @return TilesConfigurer
	 * @throws
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "classpath:tiles.xml" });
		return tilesConfigurer;
	}

	/**
	 * @Title: simpleMappingExceptionResolver
	 * @Description: (得到的自定义异常代理)
	 * @param
	 * @return ExceptionConfiguration
	 * @throws
	 */
	@Bean
	@Autowired
	public ExceptionConfiguration simpleMappingExceptionResolver() {
		ExceptionConfiguration exceptionResolver = new ExceptionConfiguration();
		Properties mappings = new Properties();
		// mappings.setProperty("AuthenticationException", "login");
		// mappings.setProperty("SessionExpirationException", "login");
		exceptionResolver.setExceptionMappings(mappings);
		return exceptionResolver;
	}

	/**
	 * @Title: messageSource
	 * @Description: (Spring国际化配置)
	 * @param
	 * @return MessageSource
	 * @throws
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource;
		messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("utf-8");
		messageSource.setFallbackToSystemLocale(false);
		messageSource.setBasename("classpath:/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		this.messageSource = messageSource;
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() throws Exception {
		LocalValidatorFactoryBean lvf = new LocalValidatorFactoryBean();
		lvf.setValidationMessageSource(messageSource);
		return lvf;
	}

	/**
	 * @Title: loginInterceptor
	 * @Description: (登陆拦截器，session过期验证)
	 * @param
	 * @return LoginInterceptor
	 * @throws
	 */
	@Bean
	public LoginInterceptor loginInterceptor() {
		LoginInterceptor loginInterceptor = new LoginInterceptor();
		return loginInterceptor;
	}

/*	@Bean
	public MessageCodesResolver messageCodesResolver() {
		DefaultMessageCodesResolver resolver = new DefaultMessageCodesResolver();
		resolver.setMessageCodeFormatter(new MyMessageCodeFormatter());
		return resolver;
	}*/
}
