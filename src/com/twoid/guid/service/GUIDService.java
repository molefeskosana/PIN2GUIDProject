package com.twoid.guid.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @Author Molefe Skosana
 * @Date 24-07-2019
 *
 */
public class GUIDService {
		
	public static String createGUIDfromPIN(String strPIN){
		
		String strGUID = "";
		try{
			
			System.out.println("Original pin: "+ strPIN);
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(
	                strPIN.getBytes(StandardCharsets.UTF_8));
	        System.out.println("After Hashing: "+ hash.toString());
	        String hexSHA = new String(Hex.encodeHex(hash));
	        System.out.println("Hex results: "+ hexSHA);
	        hexSHA = hexSHA.toUpperCase();
	        System.out.println("Hex uppercase results: "+ hexSHA);
	        strGUID = hexSHA.substring(0,8)+ "-" + hexSHA.substring(8,12)+ "-" + hexSHA.substring(12,16) + "-" + hexSHA.substring(16,20) + "-" + hexSHA.substring(20,32);
	        
		}catch(Exception ex){
			System.out.println("Error occured: "+ ex.getStackTrace());
		}

        return strGUID;
    }
}
