package com.balloon.core.collection;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 集合工具类.
 *
 * @author liaofuxing
 * @E-mail liaofuxing@outlook.com
 * @date 2020/07/02 12:37
 **/
public class CollectionUtils {

    /**
     * 判断集合是否为空
     *
     * @param cn 判断的集合
     * @return boolean 返回 true 为空, false不为空
     */
    public static <E> boolean isEmpty(Collection<E> cn) {
        return cn.isEmpty();
    }

    /**
     * 判断集合不为空
     *
     * @param cn 判断的集合
     * @return boolean 返回 true 不为空, false为空
     */
    public static <E> boolean isNotEmpty(Collection<E> cn) {
        return !cn.isEmpty();
    }

    /**
     * 将集合转换为字符串并用连接符连接, eg: @code {list = [1 2 3 4] --> String = 1, 2, 3, 4}. 其中 "," 是连接符
     *
     * @param cn     需要转换的集合
     * @param joiner 连接符号 eg: "," "#" "!"
     * @return String 返回连接符字符串
     */
    public static <E> String collectionConvertStringJoiner(Collection<E> cn, String joiner) {
        return cn.stream().map(String::valueOf).collect(Collectors.joining(joiner));
    }

}
