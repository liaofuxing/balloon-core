package com.balloon.core.observer;

import java.util.concurrent.ExecutionException;

/**
 *
 * 主题基础模板类
 *
 * @author liaofuxing
 *
 */
public class ConcreteSubject extends AbstractSubject {

    /**
     * 主题状态
     */
    private Integer status;

    /**
     *
     * 如果需要改变主题的状态,可以使用这个方法.改变主题状态,并通知所有订阅该主题的观察者
     *
     * @param data 数据
     * @param status 状态 @SubjectStatusEnums, 传入上述枚举类型可以修改主题的通知状态
     * @throws ExecutionException 异常
     * @throws InterruptedException 异常
     */
    public void changeAndNotifyObservers(Object data, Integer status) throws ExecutionException, InterruptedException {
        this.status = status;
        // 状态发生改变，通知各个观察者
        this.notifyObservers(data);
    }

    public Integer getStatus() {
        return status;
    }

}
