package com.dipu.dpms.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.dipu.dpms.config.MyJstlView;

/**
 * @ClassName: Beans4ViewResolver
 * @Description: (视图Bean定义)
 * @author WangPeng
 * @date 2016年1月6日 下午3:38:55
 */
@Configuration
@ComponentScan(basePackages = { "com.dipu.dpms" })
public class Beans4ViewResolver {

	/**
	 * @Title: contentNegotiatingViewResolver
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param
	 * @return ContentNegotiatingViewResolver
	 * @throws
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver viewResolver;
		viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}

	/**
	 * @Title: beanNameviewResolver
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param
	 * @return BeanNameViewResolver
	 * @throws
	 */
	@Bean
	public BeanNameViewResolver beanNameviewResolver() {
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(2);
		return viewResolver;
	}

	/**
	 * @Title: tilesViewResolver
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param
	 * @return TilesViewResolver
	 * @throws
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(4);
		return tilesViewResolver;
	}

	/**
	 * @Title: urlBasedViewResolver
	 * @Description: (URL视图解析器)
	 * @param
	 * @return ViewResolver
	 * @throws
	 */

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver viewResolver;
		viewResolver = new UrlBasedViewResolver();
		viewResolver.setOrder(3);
		viewResolver.setPrefix("/WEB-INF/views/url/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(MyJstlView.class);
		viewResolver.setCache(false);
		return viewResolver;
	}
}
