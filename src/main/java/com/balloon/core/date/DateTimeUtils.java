package com.balloon.core.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 时间工具类
 *
 * @author liaofuxing
 * @E-mail liaofuxing@outlook.com
 * @date 2020/06/29 13:49
 **/
public class DateTimeUtils {

    /**
     * 将 Date 转化为 jdk 1.8 的 LocalDate
     *
     * @param date 需要转换的 Data 对象
     * @return LocalDate 返回转换后的 jdk 1.8 的 LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将 Data 转换成jdk 1.8 中的 LocalDateTime 对象
     *
     * @param date 需要转换的 Data 对象
     * @return LocalDateTime 返回转换后的LocalDateTime对象
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


    /**
     * 将 LocalDateTime 转化为 jdk 1.8 的 LocalDate, 去掉时间只保留日期
     *
     * @param localDateTime 需要转换的 jdk 1.8 localDateTime
     * @return LocalDate 返回转换后的 LocalDate
     */
    public static LocalDate LocalDateTimeToLocalDate(LocalDateTime localDateTime) {
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate();
    }

    /**
     * 将 Date 转化为 jdk 1.8 的 LocalDate
     *
     * @param localDate 需要转换的 jdk 1.8 localDate
     * @return Date 返回转换后的 Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }


    /**
     * LocalDate 转换成 Data，时间取当天最小 eg: 2020-06-20 21:45:09 转换后 2020-06-20 00:00:00
     *
     * @param localDate 需要转换的 LocalDate
     * @return Date     转换后返回的 Date
     */
    public static Date localDateToDateMin(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate 转换成 Data，时间取当天最大 eg: 2020-06-20 21:45:09 转换后 2020-06-20 23:59:59
     *
     * @param localDate 需要转换的LocalDate
     * @return Date     转换后的Date
     */
    public static Date localDateToDateMax(LocalDate localDate) {
        Instant instant = LocalDateTime.of(localDate, LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


    /**
     * 指定 LocalDateTime 的具体时间, 指定一天的具体时分秒
     *
     * @param localDate 当前时间
     * @param hour      指定小时
     * @param minute    指定分钟
     * @param second    指定秒种
     * @return LocalDateTime 返回指定时分秒后的时间
     */
    public static LocalDateTime localDateAtTime(LocalDate localDate, Integer hour, Integer minute, Integer second) {
        return localDate.atTime(hour, minute, second);
    }

    /**
     * 将时间戳转换成 LocalDateTime 对象
     *
     * @param unit 时间戳
     * @return LocalDateTime 转换后的时间对象
     */
    public static LocalDateTime unitToDateTime(Long unit) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unit), ZoneId.systemDefault());
    }


    /**
     * 将 LocalDateTime 转换成时间戳
     *
     * @param localDateTime 转换的对象
     * @return long 转换后的时间戳毫秒级
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 将 LocalDateTime 对象转换成字符串，自定义格式字符串 eg:{@code yyyy-MM-dd HH:mm:ss}
     *
     * @param localDateTime 转换的对象
     * @param pattern       转换的格式
     * @return String 转换后的时间字符串
     */
    public static String formatDateTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 将 LocalDateTime 对象转换成字符串，自定义格式器 eg:{@code DateTimeFormatter.ofPattern(yyyy-MM-dd HH:mm:ss)}
     *
     * @param localDateTime     转换的对象
     * @param dateTimeFormatter 转换的格式器对象
     * @return String 转换后的时间字符串
     */
    public static String formatDateTime(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

}
