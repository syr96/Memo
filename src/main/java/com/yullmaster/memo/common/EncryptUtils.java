package com.yullmaster.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	// 암호화 메소드
	public static String md5(String message) { // 확장성을 생각해서 대중적인 이름으로 짓는다 // static 을 붙이면 객체 생성없이 사용 가능하다
		
		String encData = "";
		
		try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				
				// 00000000 총 8개의 2진수
				// asdf
				// [00000000, 00000000, 00000000, 00000000]
				byte[] bytes = message.getBytes();
				md.update(bytes);
				
				byte[] digest = md.digest();
				
				// 숫자 -> 문자열
				for(int i = 0; i < digest.length; i++) {
					encData += Integer.toHexString(digest[i] & 0xff); 
				}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		return encData;
	}
}
