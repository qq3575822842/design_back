/**
 *  Copyright (c)  2015-2050 Beijing Medsin Technology Co., Ltd.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Beijing Medsin Technology Co., Ltd.
 *  You shall not disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Beijing Medsin Technology Co., Ltd.
 */
package com.zyse.design.untils;

import org.springframework.util.StringUtils;

/**
 * 
 * @author zhangjianxing
 * @date 2015年9月15日
 */

/**
 * 全角转半角: 
 * @param fullStr 
 * @return 
 */  
public class full2HalfUtil {
	public static final String full2Half(String fullStr) {  
	    if(StringUtils.isEmpty(fullStr)){
	        return fullStr;  
	    }  
	    char[] c = fullStr.toCharArray();  
	    for (int i = 0; i < c.length; i++) {  
	        if (c[i] >= 65281 && c[i] <= 65374) {  
	            c[i] = (char) (c[i] - 65248);  
	        } else if (c[i] == 12288) { // 空格  
	            c[i] = (char) 32;  
	        }  
	    }  
	    return new String(c);  
	}  
}
