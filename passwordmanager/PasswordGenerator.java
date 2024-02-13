package com.techmplement.passwordmanager;

import java.security.SecureRandom;

public class PasswordGenerator {
	
	private static final SecureRandom random =new SecureRandom();
	private static final String cap="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String small_cap="abcdefghijklmnopqrstuvwxyz";
	private static final String numeric="1234567890";
	private static final String spec_char="~!@#$%^&*(_+{}|:_[?]>=<";
	private static final String dic=cap+small_cap+numeric+spec_char;
	
	public String generatePassword(int len)
	{
		StringBuilder pass=new StringBuilder();
		for (int i = 0; i < len; i++) {
			int index=random.nextInt(dic.length());
			pass.append(dic.charAt(index));
			
		}
		return pass.toString();
		
	}
}
