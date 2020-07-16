package com.balloon.core.observer;


/**
 * 抽象观察者
 *
 * @author liaofuxing
 * @since 1.0.0
 */
public abstract class AbstractObServer implements ObServer {

    /**
     * 观察者名称
     */
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
