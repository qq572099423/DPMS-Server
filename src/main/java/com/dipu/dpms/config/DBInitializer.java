package com.dipu.dpms.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName: DBInitializer
 * @Description: (这个类主要用来初始化数据库)
 * @author WangPeng
 * @date 2016年1月6日 下午3:36:03
 */
public class DBInitializer {

  @Autowired
  private SessionFactory sessionFactory;

  /**
   * @Title: initDB
   * @Description: (系统启动时会调用此方法，可加入数据库初始化代码：如基础数据的录入)
   * @param
   * @return void
   * @throws
   */
  public void initDB() {
    // TODO 之后将在这里初始化数据库
  }
}
