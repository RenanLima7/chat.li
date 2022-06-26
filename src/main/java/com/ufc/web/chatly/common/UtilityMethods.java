package com.ufc.web.chatly.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class UtilityMethods {
	
	public static String encode(String file) throws UnsupportedEncodingException{
		return Base64.getEncoder().encodeToString(file.getBytes("UTF-8"));
	}
		
	public static byte[] decode(String fileBase64){
		return Base64.getDecoder().decode(fileBase64);
	}
	
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}
}
