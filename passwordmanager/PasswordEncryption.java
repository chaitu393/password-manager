package com.techmplement.passwordmanager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncryption {
	
	public static String SHA_1_securepassword(String hashToStr,byte[] salt)
	{
		String generatePassword=null;
		try {
			MessageDigest msd=MessageDigest.getInstance("SHA-1");
			msd.update(salt);
			byte[] bytes = msd.digest(hashToStr.getBytes());
			StringBuilder sb=new StringBuilder();
			for (byte b : bytes) {
				sb.append(Integer.toString((b& 0xff) + 0x100, 16).substring(1));
				
				
			}
			generatePassword=sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return generatePassword;
		
	}
	public static byte[] getSalt() throws NoSuchAlgorithmException
	{
		SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
		byte[] salt=new byte[16];
		random.nextBytes(salt);
		
		return salt;
		
	}

}
