/*
    Copyright (c) [2020] [liaofuxing]
    [balloon-core] is licensed under Mulan PSL v2.
    You can use this software according to the terms and conditions of the Mulan PSL v2.
    You may obtain a copy of Mulan PSL v2 at:
              http://license.coscl.org.cn/MulanPSL2
    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
    See the Mulan PSL v2 for more details.
 */

package com.balloon.core.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * 主题抽象类
 *
 * @param <T> 通知数据的泛型类型
 * @author liaofuxing
 */
public abstract class AbstractSubject implements Subject {

    private static final Logger logger = Logger.getLogger(String.valueOf(AbstractSubject.class));


    /**
     * 用来保存注册的观察者对象
     */
    private List<ObServer> list = new ArrayList<>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void add(ObServer observer) {
        list.add(observer);
        logger.info("add observer success");
    }

    /**
     * 移除观察者对象
     *
     * @param observer 观察者对象
     */
    public void delete(ObServer observer) {
        list.remove(observer);
    }

    /**
     * 移除所有观察者
     */
    public void deleteAll() {
        list.clear();
    }


    /**
     * 通知所有注册的观察者
     *
     * @param data 数据
     * @throws ExecutionException   异常
     * @throws InterruptedException 异常
     */
    public void notifyObservers(Object data) throws ExecutionException, InterruptedException {
        for (ObServer observer : list) {
            observer.execute(data);
        }
    }
}
