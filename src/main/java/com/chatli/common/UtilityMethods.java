package com.ufc.web.chatly.common;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilityMethods {
		
	public static String base64Decode(String value) {
        try {
            byte[] decodedValue = Base64.getDecoder().decode(value);
            return new String(decodedValue, StandardCharsets.UTF_8.toString());        
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String base64Encode(String value) {
        try {
            return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8.toString()));        
        } catch(UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
	
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String encryptWithMD5(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, messageDigest.digest(password.getBytes()));
			return hash.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
	public static Boolean compareEncryptedPassword(String password, String passwordInDB) {
		try {			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder.matches(password, passwordInDB);			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String encryptWithBCrypt(String password) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder.encode(password);
		} catch (Exception e) {
			return "";
		}
	}
}
