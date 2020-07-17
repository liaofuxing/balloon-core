package com.balloon.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加解密工具
 *
 * @author liaofuxing
 */
public class EncryptionUtil {

    /**
     * MD5 加密
     *
     * @param inputText 输入的字符串
     * @return String 转化16进制的字符串
     * @throws NoSuchAlgorithmException 异常
     */
    public static String enCodeMD5(String inputText) throws NoSuchAlgorithmException {
        return hex(MessageDigest.getInstance("md5").digest(inputText.getBytes()));
    }

    /**
     * SHA-256 加密
     *
     * @param inputText 输入的字符串
     * @return String 转化16进制的字符串
     * @throws NoSuchAlgorithmException 异常
     */
    public static String enCodeSHA256(String inputText) throws NoSuchAlgorithmException {
        return hex(MessageDigest.getInstance("SHA-256").digest(inputText.getBytes()));
    }

    /**
     * Base64 加密
     * <p>ps: 严格意义上说 Base64 不算加密, 因为可以解密,不建议用于安全级别高的场景</p>
     *
     * @param inputText 输入的字符串
     * @return 返回加密后的字符串
     */
    public static String enCodeBase64(String inputText) {
        //Base64 加密
        byte[] bytes = inputText.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Base64 解密
     *
     * @param base64Str base64Str 加密后的字符串
     * @return 返回解密后的字符串
     */
    public static String deCodeBase64(String base64Str) {
        byte[] decoded = Base64.getDecoder().decode(base64Str);
        return new String(decoded);
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr 需要转16进制的byte数组
     * @return 16进制字符串
     */
    public static String hex(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

}
