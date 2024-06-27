package org.example.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccountHandler {
    public static String hashPassword(String password) {
        MessageDigest md;
        String result = "";
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            BigInteger bi = new BigInteger(1, md.digest());

            result = "15dgc4" + bi.toString(16) + "@ca86";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean checkUsername(String username){
        return username.matches("[a-zA-Z0-9]*") && username.length() <= 45;
    }
}
