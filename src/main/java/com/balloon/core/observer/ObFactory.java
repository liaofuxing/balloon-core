package com.balloon.core.observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * observer静态工厂
 * <p>需要将主题和订阅者进行管理时可使用该工厂进行操作</p>
 *
 * @author liaofuxing
 * @since 1.0.0
 */
public class ObFactory {

    private static final Map<String, Subject> subjectMap = new ConcurrentHashMap<>();

    /**
     * 添加主题到工厂中
     *
     * @param key   key值
     * @param value 主题
     */
    public static void add(String key, Subject value) {
        subjectMap.put(key, value);
    }

    /**
     * 删除工厂中的主题
     *
     * @param key key值
     */
    public static void remove(String key) {
        subjectMap.remove(key);
    }


    /**
     * 删除工厂中的所有主题
     */
    public static void removeAll() {
        subjectMap.clear();
    }

    /**
     * 根据别名获取工厂的主题
     *
     * @param key key值
     * @return 返回的主题
     */
    public static Subject get(String key) {
        return subjectMap.get(key);
    }


    /**
     * 通过工厂生成一个指定 key 值的主题
     *
     * @param key key值
     * @return 返回的主题
     */
    public static Subject generateSubject(String key) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        add(key, concreteSubject);
        return concreteSubject;
    }

    /**
     * 根据 key 查找主题.
     * <p>如果没有找到, 就通过静态工场创建一个主题,并加入工厂, 通过 key 值管理(@param key)这个主题</p>
     *
     * @param key key值
     * @return 返回的主题
     */
    public static Subject getOrCreate(String key) {
        if (get(key) == null) {
            return generateSubject(key);
        }
        return get(key);
    }
}
