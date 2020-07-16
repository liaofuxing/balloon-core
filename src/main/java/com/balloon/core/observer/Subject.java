package com.balloon.core.observer;

import java.util.concurrent.ExecutionException;

/**
 * 主题接口
 *
 * @author liaofuxing
 * @since 1.0.0
 */
public interface Subject {

    /**
     * 添加观察者
     *
     * @param obServer 观察者
     */
    void add(ObServer obServer);

    /**
     * 删除观察者
     *
     * @param obServer 观察者
     */
    void delete(ObServer obServer);

    /**
     * 删除所有观察者
     */
    void deleteAll();

    /**
     * 通知观察者
     *
     * @param data 数据
     * @throws ExecutionException   执行异常
     * @throws InterruptedException 中断异常
     */
    void notifyObservers(Object data) throws ExecutionException, InterruptedException;
}