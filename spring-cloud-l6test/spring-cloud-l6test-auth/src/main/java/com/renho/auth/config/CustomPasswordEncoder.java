package com.renho.auth.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {

        try {
            return encode(rawPassword.toString());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return "";
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            if (encodedPassword != null && rawPassword != null
                    && encodedPassword.equals(encode(rawPassword.toString()))) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            return false;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return false;
    }

    public String encode(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

}
