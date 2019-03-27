package com.zyse.design.untils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptorgaphyUtil {
	public static String  encBase64(String str){
		return Base64.encodeToString(str.getBytes());
	}
	
	public static String  deccBase64(String str){
		return Base64.decodeToString(str);
	}
	public static String  GetMD5Code(String str,String salt){
		return new Md5Hash(str, salt).toString();
	}

}
