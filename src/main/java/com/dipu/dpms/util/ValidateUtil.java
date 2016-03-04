package com.dipu.dpms.util;

/**
 * @ClassName: ValidateUtil
 * @Description: 验证工具类
 * @author WangPeng
 * @date 2016年1月13日 下午2:27:57
 */
public class ValidateUtil {

  /**
   * @Title: notNull
   * @Description: 验证输入是否为null值
   * @param @param obj
   * @param @param fieldCode
   * @param @throws Exception 设定文件
   * @return void 返回类型
   * @throws
   */
  public static void notNull(Object obj, String fieldCode) throws Exception {
    if (null == obj) {
      throw new Exception(getMessage("VALIDATE.NOTNULL", getMessage(fieldCode.toUpperCase())));
    }
  }

  /**
   * @Title: isNull
   * @Description: 验证输入是否为null值
   * @param @param obj
   * @param @param fieldCode
   * @param @throws Exception 设定文件
   * @return boolean 返回类型
   * @throws
   */
  public static boolean isNull(Object obj, String fieldCode, ResultMap resultMap) {
    if (null == obj) {
      resultMap.setMessage(getMessage("VALIDATE.NOTNULL", getMessage(fieldCode.toUpperCase())));
      return true;
    } else {
      return false;
    }
  }

  /**
   * @Title: notEmpty
   * @Description: 验证输入是否为null值
   * @param @param obj
   * @param @param fieldCode
   * @param @throws Exception 设定文件
   * @return void 返回类型
   * @throws
   */
  public static void notEmpty(String str, String fieldCode) throws Exception {
    if (null == str || "".equals(str)) {
      throw new Exception(getMessage("VALIDATE.NOTEMPTY", getMessage(fieldCode.toUpperCase())));
    }
  }

  /**
   * @Title: isEmpty
   * @Description: 验证输入是否为null值
   * @param @param obj
   * @param @param fieldCode
   * @param @throws Exception 设定文件
   * @return void 返回类型
   * @throws
   */
  public static boolean isEmpty(String str, String fieldCode, ResultMap resultMap) {
    if (null == str || "".equals(str)) {
      resultMap.setMessage(getMessage("VALIDATE.NOTEMPTY", getMessage(fieldCode.toUpperCase())));
      return true;
    } else {
      return false;
    }
  }

  /**
   * @Title: getMessage
   * @Description: 根据消息code和参数获取消息
   * @param @param code
   * @param @param args
   * @param @return 设定文件
   * @return String 返回类型
   * @throws
   */
  private static String getMessage(String code, Object... args) {
    return MessageSourceUtil.loadMesage(code, args);
  }
}
