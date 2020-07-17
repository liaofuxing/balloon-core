package com.balloon.core.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数和随机字母工具类.
 *
 * @author liaofuxing
 * @E-mail liaofuxing@outlook.com
 * @date 2020/06/30 17:20
 **/
public class RandomUtils {

    /**
     * 生成任意区间的整数
     *
     * @param min 区间最小值 不包含
     * @param max 区间最大值 包含
     * @return Integer 返回生成的随机数
     */
    public static Integer randomNumberMinToMax(Integer min, Integer max) {
        // int num = ThreadLocalRandom.current().ints(min, max). 生成规则是 min <= num < max
        // 所以想要包含 max 的数值必须使用 max + 1
        return ThreadLocalRandom.current().ints(min, max + 1).findFirst().getAsInt();
    }

    /**
     * 生成A-Z 之间的字母
     *
     * @return String 返回生成的随机字母
     */
    public static String randomLetterUpperCase() {
        return randomLetterUpperCaseMinToMax("A", "Z");
    }

    /**
     * 生成a-z 之间的字母
     *
     * @return String 返回生成的随机字母
     */
    public static String randomLetterLowerCase() {
        return randomLetterLowerCaseMinToMax("a", "z");
    }

    /**
     * 生成任意区间的字母,大写
     *
     * @param minLetter 区间最小字符 包含   ps:支持大小写，自动转换为大写
     * @param maxLetter 区间最大字符 包含   ps:支持大小写，自动转换为大写
     * @return String 返回生成的随机字母
     */
    public static String randomLetterUpperCaseMinToMax(String minLetter, String maxLetter) {
        String letter;
        try {
            char minLetterChar = minLetter.toUpperCase().toCharArray()[0];
            char maxLetterChar = maxLetter.toUpperCase().toCharArray()[0];
            int i = randomNumberMinToMax((int) minLetterChar, (int) maxLetterChar);
            char randomLetterChar = (char) i;
            letter = String.valueOf(randomLetterChar);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassCastException("传入的最小参数必须比最大参数小,并且只能是A-Z或a-z之间的字符串,不区分大小写.");
        }
        return letter;
    }

    /**
     * 生成任意区间的字母,小写
     *
     * @param minLetter 区间最小字符 包含   ps:支持大小写，自动转换为小写
     * @param maxLetter 区间最大字符 包含   ps:支持大小写，自动转换为小写
     * @return String 返回生成的随机字母
     */
    public static String randomLetterLowerCaseMinToMax(String minLetter, String maxLetter) {
        String letter;
        try {
            char minLetterChar = minLetter.toLowerCase().toCharArray()[0];
            char maxLetterChar = maxLetter.toLowerCase().toCharArray()[0];
            int i = randomNumberMinToMax((int) minLetterChar, (int) maxLetterChar);
            char randomLetterChar = (char) i;
            letter = String.valueOf(randomLetterChar);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("传入的最小参数必须比最大参数小,并且只能是A-Z或a-z之间的字符串,不区分大小写.");
        }
        return letter;
    }

    /**
     * 随机生成任意长度的数字字母组合字符串
     *
     * @param len 生成长度
     * @return String 返回生成的随机长的数字字母组合字符串
     */
    public static String randomLetterOrNumber(Integer len) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < len; i++){
            switch(randomNumberMinToMax(1, 3)){
                case 1 :
                    stringBuffer.append(randomNumberMinToMax(0, 9));
                    break;
                case 2 :
                    stringBuffer.append(randomLetterUpperCase());
                    break;
                case 3 :
                    stringBuffer.append(randomLetterLowerCase());
                    break;
            }
        }
       return stringBuffer.toString();
    }

    /**
     * 随机生成任意长度的数字字符串
     *
     * @param len 生成长度
     * @return String 返回生成的随机长的数字字母组合字符串
     */
    public static String randomNumber(Integer len) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < len; i++){
            stringBuffer.append(randomNumberMinToMax(0, 9));
        }
        return stringBuffer.toString();
    }

    /**
     * 随机生成任意长度的大写字母字符串
     *
     * @param len 生成长度
     * @return String 返回生成的随机长的数字字母组合字符串
     */
    public static String randomLetterOnlyUpperCaseLen(Integer len) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < len; i++){
            stringBuffer.append(randomLetterUpperCase());
        }
        return stringBuffer.toString();
    }

    /**
     * 随机生成任意长度的小写字母字符串
     *
     * @param len 生成长度
     * @return String 返回生成的随机长的数字字母组合字符串
     */
    public static String randomLetterOnlyLowerCaseLen(Integer len) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < len; i++){
            stringBuffer.append(randomLetterLowerCase());
        }
        return stringBuffer.toString();
    }

    /**
     * 随机生成任意长度的大小写字母组合字符串
     *
     * @param len 生成长度
     * @return String 返回生成的随机长的数字字母组合字符串
     */
    public static String randomLetterUpperCaseOrLowerCaseLen(Integer len) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < len; i++){
            switch(randomNumberMinToMax(1, 2)){
                case 1 :
                    stringBuffer.append(randomLetterUpperCase());
                    break;
                case 2 :
                    stringBuffer.append(randomLetterLowerCase());
                    break;
            }
        }
        return stringBuffer.toString();
    }
}
