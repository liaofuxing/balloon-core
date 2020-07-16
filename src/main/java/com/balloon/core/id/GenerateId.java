
package com.balloon.core.id;

/**
 * id生成接口
 *
 * @param <T>
 * @author liaofuxing
 */
public interface GenerateId<T> {

    /**
     * id生成
     *
     * @return id结果
     */
    T generateId();
}