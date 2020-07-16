package com.balloon.core.observer.test;

import com.balloon.core.observer.AbstractObServer;


public class TestObserver extends AbstractObServer {


    public TestObserver(String name){
        super.setName(name);
    }

    @Override
    public void execute(Object data) {
        System.out.println("数据：" + data);
    }
}
