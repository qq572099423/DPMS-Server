package com.dipu.dpms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipu.dpms.repository.CommonRepository;
import com.dipu.dpms.service.CommonService;


@Service("commonService")
public class CommonServiceImpl implements CommonService {

  @Autowired
  protected CommonRepository repository;

  @Transactional
  @Override
  public <T> T save(T t) {
    return this.repository.save(t);
  }

  @Transactional
  @Override
  public <T> T update(T t) {
    return this.repository.update(t);
  }

  @Transactional
  @Override
  public <T> T delete(T t) {
    return this.repository.delete(t);
  }

  @Override
  public <T> List<T> findAll(Class<T> clazz) {
    return this.repository.findAll(clazz);
  }


  @Override
  public <T> T findById(long id, Class<T> clazz) {
    return this.repository.findById(id, clazz);
  }


  @Override
  public <T> long getCount(Class<T> clazz) {
    return this.repository.getCount(clazz);
  }

  @Override
  public <T> List<T> getListByWhere(String where, Class<T> clazz) {
    return this.repository.getListByWhere(where, clazz);
  }

}
