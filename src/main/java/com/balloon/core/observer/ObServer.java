package com.balloon.core.observer;

import java.util.concurrent.ExecutionException;

/**
 * 观察者接口
 *
 * @author liaofuxing
 * @since 1.0.0
 */
public interface ObServer {


    /**
     * 获取观察者的名称
     *
     * @return 观察者的名称
     */
    String getName();


    /**
     * 观察者被通知后执行的方法
     *
     * @param data 请求的数据
     * @throws ExecutionException   执行异常
     * @throws InterruptedException 断开异常
     */
    void execute(Object data) throws ExecutionException, InterruptedException;
}
