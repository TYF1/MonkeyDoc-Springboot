package com.monkeydoc.tools;

import org.apache.tomcat.util.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenProcessor {
    private TokenProcessor() {
    }

    private static final TokenProcessor instance = new TokenProcessor();

    public static TokenProcessor getInstance() {
        return instance;
    }

    public String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            Base64 base64 = new Base64();
            return base64.encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}