package com.dipu.dpms.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dipu.dpms.repository.CommonRepository;
import com.dipu.dpms.util.CommonUtil;

@Repository("commonRepository")
public class CommonRepositoryImpl implements CommonRepository {

  @Autowired
  protected SessionFactory sessionFactory;

  @Override
  @Transactional
  public <T> T save(T t) {
    this.sessionFactory.getCurrentSession().save(t);
    return t;
  }

  @Override
  @Transactional
  public <T> T update(T t) {
    this.sessionFactory.getCurrentSession().update(t);
    return t;
  }

  @Override
  @Transactional
  public <T> T delete(T t) {
    this.sessionFactory.getCurrentSession().delete(t);
    return t;
  }

  @Override
  public <T> T findById(long id, Class<T> clazz) {
    Session session = this.sessionFactory.getCurrentSession();
    String entityName = CommonUtil.getEntityNameByClass(clazz);
    @SuppressWarnings("unchecked")
    List<T> resultList = session.createQuery("select u from " + entityName + " u where id = :id").setLong("id", id).list();
    if (resultList.size() > 0) {
      T account = (T) resultList.get(0);
      return account;
    }
    return null;
  }

  @Override
  public <T> List<T> findAll(Class<T> clazz) {
    Session session = this.sessionFactory.getCurrentSession();
    String entityName = CommonUtil.getEntityNameByClass(clazz);
    @SuppressWarnings("unchecked")
    List<T> resultList = session.createQuery("select u from " + entityName + " u").list();
    if (resultList.size() > 0) {
      return resultList;
    }
    return null;
  }

  @Override
  public <T> long getCount(Class<T> clazz) {
    Session session = this.sessionFactory.getCurrentSession();
    String entityName = CommonUtil.getEntityNameByClass(clazz);
    Long count = (Long) session.createQuery("select count(1) from " + entityName + " u").uniqueResult();
    return count;
  }

  @Override
  public <T> List<T> getListByWhere(String where, Class<T> clazz) {
    Session session = this.sessionFactory.getCurrentSession();
    String entityName = CommonUtil.getEntityNameByClass(clazz);
    @SuppressWarnings("unchecked")
    List<T> resultList = session.createQuery("select u from " + entityName + " u " + where).list();
    if (resultList.size() > 0) {
      return resultList;
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Object[]> searchBySqlQuery(String sql) {
    Session session = this.sessionFactory.getCurrentSession();
    return session.createSQLQuery(sql).list();
  }
}
