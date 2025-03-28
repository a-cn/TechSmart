package com.techsmart.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtil {
	public static String sha1(String value) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("SHA-1");
            byte[] buf = value.getBytes();
            algorithm.reset();
            algorithm.update(buf);
            byte[] result = algorithm.digest();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
