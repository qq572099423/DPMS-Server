package com.dipu.dpms.util;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

/**
 * @ClassName: ResultMap
 * @Description: 统一处理返回实体类
 * @author WangPeng
 * @date 2016年1月13日 下午2:23:45
 */
public class ResultMap implements Serializable {
  /**
   * @Fields serialVersionUID :
   */
  private static final long serialVersionUID = -7272104779838904640L;
  /**
   * 本次处理是否成功
   */
  private boolean hasSuccess = false;
  /**
   * 明细数据封装
   */
  private ModelMap map = new ModelMap();
  /**
   * 本次处理的返回信息
   */
  private String message;

  public boolean isHasSuccess() {
    return hasSuccess;
  }

  public void setHasSuccess(boolean hasSuccess) {
    this.hasSuccess = hasSuccess;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ModelMap getMap() {
    return map;
  }

  public void setMap(ModelMap map) {
    this.map = map;
  }

  public void put(String key, Object value) {
    map.put(key, value);
  }

  public Object get(String key) {
    return map.get(key);
  }

  public boolean containsKey(String key) {
    return map.containsKey(key);
  }

  public boolean containsValue(Object value) {
    return map.containsValue(value);
  }

}
