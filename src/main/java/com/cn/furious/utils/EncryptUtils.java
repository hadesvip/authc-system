package com.cn.furious.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhuminghua on 14-9-28.
 */
public class EncryptUtils {
    /**
     * Encrypt string using MD5 algorithm
     */
    public final static String encryptMD5(String source) {
        if (source == null) {
            source = "";
        }
        String result = "";
        try {
            result = encrypt(source, "MD5");
        } catch (NoSuchAlgorithmException ex) {
            // this should never happen
            throw new RuntimeException(ex);
        }
        return result;
    }
    /**
     * Encrypt string using SHA algorithm
     */
    public final static String encryptSHA(String source) {
        if (source == null) {
            source = "";
        }
        String result = "";
        try {
            result = encrypt(source, "SHA");
        } catch (NoSuchAlgorithmException ex) {
            // this should never happen
            throw new RuntimeException(ex);
        }
        return result;
    }
    /**
     * Encrypt string
     */
    private final static String encrypt(String source, String algorithm)
            throws NoSuchAlgorithmException {
        byte[] resByteArray = encrypt(source.getBytes(), algorithm);
        return toHexString(resByteArray);
    }
    /**
     * Encrypt byte array.
     */
    private final static byte[] encrypt(byte[] source, String algorithm)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.reset();
        md.update(source);
        return md.digest();
    }
    /**
     * Get hex string from byte array
     */
    private final static String toHexString(byte[] res) {
        StringBuffer sb = new StringBuffer(res.length << 1);
        for (int i = 0; i < res.length; i++) {
            String digit = Integer.toHexString(0xFF & res[i]);
            if (digit.length() == 1) {
                digit = '0' + digit;
            }
            sb.append(digit);
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String v1 = EncryptUtils.encryptMD5("ea1ff591ff578ec9274867bb7f494ab8");
        System.out.println(v1);
    }
}
