package com.balloon.core.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map 工具类.
 *
 * @author liaofuxing
 */
public class MapUtils {

    /**
     * 判断 map 是否为空
     *
     * @param map 要判断的map
     * @return boolean 返回true为空, false不为空
     */
    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map.isEmpty();
    }

    /**
     * 判断 map 不为空
     *
     * @param map 需要判断的 map
     * @return boolean 返回true为不为空, false为空
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !map.isEmpty();
    }

    /**
     * key是否存在
     *
     * @param map 需要比较的 map
     * @param key 需要比较的 key
     * @return boolean 返回 true 存在，返回 false 不存在
     */
    public static <K, V> boolean isExistsInMapByKey(Map<K, V> map, K key) {
        if (map == null || key == null) {
            return false;
        }
        return map.containsKey(key);
    }

    /**
     * 将 map 按 key 值升序排序
     * <p>如果 map 的 key 值是一个整数字符串, 尝试将该 map 按 key 值以升序排序</p>
     *
     * @param map 需要排序的 map
     * @return Map<K, V> 返回已经排序完成的 map
     */
    public static <K, V> Map<K, V> sortMapAscByKey(Map<K, V> map) {
        TreeMap<K, V> sortMap = new TreeMap<>(new MapKeyComparatorAsc<>());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 将 map 按 key 值降序排序
     * <p>如果 map 的 key 值是一个整数字符串, 尝试将该 map 按 key 值以降序排序</p>
     *
     * @param map 需要排序的 map
     * @return Map<K, V> 返回已经排序完成的 map
     */
    public static <K, V> Map<K, V> sortMapDescByKey(Map<K, V> map) {
        TreeMap<K, V> sortMap = new TreeMap<>(new MapKeyComparatorDesc<>());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 升序排序器
     *
     * @param <T>
     */
    private static class MapKeyComparatorAsc<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return (Integer.valueOf(o1.toString())).compareTo(Integer.valueOf(o2.toString()));
        }
    }

    /**
     * 降序排序器
     *
     * @param <T>
     */
    private static class MapKeyComparatorDesc<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return (Integer.valueOf(o2.toString())).compareTo(Integer.valueOf(o1.toString()));
        }
    }


    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("2", 2);
        objectObjectHashMap.put("1", 2);
        objectObjectHashMap.put("10", 2);
        objectObjectHashMap.put("12", 2);
        System.out.println(sortMapDescByKey(objectObjectHashMap));
        System.out.println(sortMapAscByKey(objectObjectHashMap));

        System.out.println(isExistsInMapByKey(objectObjectHashMap, "3"));
        System.out.println(isEmpty(objectObjectHashMap));
        System.out.println(isNotEmpty(objectObjectHashMap));
    }
}
