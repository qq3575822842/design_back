package com.zyse.design.untils;

import java.util.UUID;

/**
 * 生产主键
 * @description: 功能描述
 * @Author: 梦醒灬纠结
 * @Date: 2019/3/20 17:49
 */
public class UUIDKeyUtil {

    /**
     * 生产32位主键
     * @description:功能描述
     * @param:
     * @return: str
     * @Author: yc
     * @date: 2018/12/11 17:50
     */
  public  static String uuIdKey(){

      UUID uuid = UUID.randomUUID();
      String str = uuid.toString();
      str = str.replace("-", "");

      return str;

  }
}
