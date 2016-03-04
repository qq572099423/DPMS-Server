package com.dipu.dpms.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: CommonUtil
 * @Description: 通用工具类
 * @author WangPeng
 * @date 2016年1月13日 下午1:44:37
 */
public class CommonUtil {
  /**
   * BigInteger To Long
   * 
   * @param obj
   * @return
   */
  public static Long BigInteger2Long(Object obj) {
    return (obj == null ? null : ((BigInteger) obj).longValue());
  }

  /**
   * Integer To Long
   * 
   * @param obj
   * @return
   */
  public static Long Integer2Long(Object obj) {
    return (obj == null ? null : ((Integer) obj).longValue());
  }

  /**
   * BigInteger To Int
   * 
   * @param obj
   * @return
   */
  public static Integer BigInteger2Int(Object obj) {
    return (obj == null ? null : ((BigInteger) obj).intValue());
  }

  /**
   * Object to String
   * 
   * @param obj
   * @return
   */
  public static String Object2String(Object obj) {
    return obj == null ? "" : obj.toString();
  }

  public static BigDecimal Object2BigDecical(Object obj) {
    return obj == null ? BigDecimal.ZERO : (BigDecimal) obj;
  }

  /**
   * @Title: isObjectEmpty
   * @Description: 判断对象是否为空
   * @param @param str
   * @return boolean 返回类型
   * @throws
   */
  public static boolean isObjectEmpty(Object str) {
    return (str == null || "".equals(str));
  }

  /**
   * @Title: join
   * @Description: list用字符分割
   * @param @param list
   * @param @param c
   * @return 返回类型
   * @throws
   */
  public static String join(List<?> list, String c) {
    StringBuilder sb = new StringBuilder();
    if (list != null && list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        if (i < list.size() - 1) {
          sb.append(list.get(i) + c);
        } else {
          sb.append(list.get(i));
        }
      }
    }
    return sb.toString();
  }

  /**
   * @Title: join
   * @Description:数组用字符分割
   * @param @param arr
   * @param @param c
   * @return 返回类型
   * @throws
   */
  public static String join(Object[] arr, String c) {
    StringBuilder sb = new StringBuilder();
    if (arr != null && arr.length > 0) {
      for (int i = 0; i < arr.length; i++) {
        if (i < arr.length - 1) {
          sb.append(arr[i] + c);
        } else {
          sb.append(arr[i]);
        }
      }
    }
    return sb.toString();
  }

  /**
   * @Title: getMd5
   * @Description: MD5加密
   * @param 待加密的字符串
   * @return MD5加密字符串
   * @throws
   */
  public static String getMd5(final String s) {
    char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    try {
      byte[] btInput = s.getBytes();
      // 获得MD5摘要算法的 MessageDigest 对象
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      // 使用指定的字节更新摘要
      mdInst.update(btInput);
      // 获得密文
      byte[] md = mdInst.digest();
      // 把密文转换成十六进制的字符串形式
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getEntityNameByClass(Class<?> clazz) {
    String name = null;
    Entity entity = clazz.getAnnotation(Entity.class);
    if(entity != null){
      name = entity.name();
      if(!isObjectEmpty(name)){
        return name;
      }
    }
    return clazz.getSimpleName();
  }
  /**
  * @Title: isAjax 
  * @Description: (这里用一句话描述这个方法的作用) 
  * @param @param request
  * @param @return    设定文件 
  * @return boolean    返回类型 
  * @throws
   */
  public static boolean isAjax(HttpServletRequest request) {
    boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    String ajaxFlag = null == request.getParameter("ajax") ? "false" : request.getParameter("ajax");
    return ajax || ajaxFlag.equalsIgnoreCase("true");
  }
}
