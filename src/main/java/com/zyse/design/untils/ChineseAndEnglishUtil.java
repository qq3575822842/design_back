package com.zyse.design.untils;

/**
 * @description: 判断中文,英文,数字
 * @Author: 梦醒灬纠结
 * @Date: 2019/3/19 11:27
 */
public class ChineseAndEnglishUtil {

    /**
     * @description:判断是不是全中文
     * @param:
     * @return: true：是  false：不是
     * @Author: yc
     * @date: 2019/3/19 11:39
     */
    public static boolean getChinese(String Chinese){

        String reg = "[\\u4e00-\\u9fa5]+";

        if(Chinese.trim().matches(reg)){

            return true;
        }
        return false;

    }
    /**
     * @description:判断是不是全英文
     * @param:
     * @return: true：是  false：不是
     * @Author: yc
     * @date: 2019/3/19 11:39
     */
    public static boolean getEnglish(String English){

        String reg = "^[a-zA-Z]*";

        if(English.trim().matches(reg)){

            return true;
        }
        return false;

    }

    /**
     * @description:判断是不是全数字
     * @param:
     * @return: true：是  false：不是
     * @Author: yc
     * @date: 2019/3/19 11:39
     */
    public static boolean getNumber(String Number){

        String reg = "[0-9]*";

        if(Number.trim().matches(reg)){

            return true;
        }
        return false;

    }
}
