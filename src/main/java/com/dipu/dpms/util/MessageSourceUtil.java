package com.dipu.dpms.util;

import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MessageSourceUtil
 * @Description: (获取国际化文本)
 * @author WangPeng
 * @date 2016年1月12日 下午5:02:53
 */
@Component
public class MessageSourceUtil {
  private static ReloadableResourceBundleMessageSource messageSource;

  public static String loadMesage(String msgCode, Object... args) {
    if (messageSource == null) {
      messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasename("classpath:/messages");
      messageSource.setUseCodeAsDefaultMessage(true);
    }
    return messageSource.getMessage(msgCode, args, Locale.getDefault());
  }
}
