package com.balloon.core.utils;

/**
 * 字符串工具类
 *
 * @author liaofuxing
 */
public class StringUtils {

    /**
     * 判断字符串是否是空
     *
     * @param cs 判断的字符串
     * @return boolean 返回true为空, false不为空
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断字符串不为空
     *
     * @param cs 判断的字符串
     * @return boolean 返回true为空, false不为空
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !(cs == null || cs.length() == 0);
    }

    /**
     * 判断字符串是否是空, "null"或"NULL" 也为空
     *
     * @param cs 判断的字符串
     * @return boolean 返回true为空, false不为空
     */
    public static boolean isEmptyNull(CharSequence cs) {
        return cs == null || cs.length() == 0 || "null".contentEquals(cs) || "NULL".contentEquals(cs);
    }

    /**
     * 将字符串转换为java驼峰风格, 首字母小写 @code{str = "user_id" --> javaHump = "userId"}
     * first code lower case
     *
     * @param str 需要转换的字段
     * @return javaHump java驼峰字符串
     */
    public static String firstCodeLowerCaseConvertJavaHump(String str) {
        // 替换数据库中的"_"字符, 用java驼峰命名
        String javaHump;
        if (str.contains("_")) {
            // 第一个出现的索引位置
            StringBuilder mysqlFieldBuilder = new StringBuilder(str);
            int indexOf = str.indexOf("_");
            char c = str.charAt(indexOf + 1);
            javaHump = mysqlFieldBuilder.replace(indexOf,
                    indexOf + 2,
                    " " + String.valueOf(c).toUpperCase()).toString();
            while (indexOf != -1) {
                // 从这个索引往后开始第一个出现的位置
                indexOf = str.indexOf("_", indexOf + 1);
                if (indexOf != -1) {
                    javaHump = firstCodeLowerCaseConvertJavaHump(javaHump);
                }
            }
        } else {
            javaHump = str;
        }
        return javaHump.replace(" ", "");
    }

    /**
     * 将字段转换为表名, 类名风格, 首字母大写 @code{str = "user_id" --> tableName = "UserId"}
     * first code upper case
     *
     * @param str 需要转换的字段
     * @return tableNameBuilder.toString() 表名驼峰字符串
     */
    public static String firstCodeUpperConvertJavaHump(String str) {
        String tableName = firstCodeLowerCaseConvertJavaHump(str);
        StringBuilder tableNameBuilder = new StringBuilder(tableName);
        String firstStr = tableName.substring(0, 1);
        tableNameBuilder.replace(0, 1, firstStr.toUpperCase());

        return tableNameBuilder.toString();
    }


    public static void main(String[] args) {
//        System.out.println(isEmpty(""));
//        System.out.println(isNotEmpty(""));
//        System.out.println(isNotEmpty(null));
//        System.out.println(isNotEmpty("null"));
//        InetAddress addr = InetAddress.getLocalHost();
//        System.out.println("Local HostAddress: "+addr.getHostAddress());
//                String hostname = addr.getHostName();
//        System.out.println("Local host name: "+hostname);


        System.out.println(firstCodeLowerCaseConvertJavaHump("uuu_ppp"));
        System.out.println(firstCodeUpperConvertJavaHump("uuu_ppp"));
        System.out.println(isNotEmpty("null"));
    }
}
