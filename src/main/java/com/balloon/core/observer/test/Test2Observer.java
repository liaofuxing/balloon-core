package com.balloon.core.observer.test;

import com.balloon.core.observer.AbstractObServer;


public class Test2Observer extends AbstractObServer {

    public Test2Observer(String name){
        super.setName(name);
    }

    @Override
    public void execute(Object data) {
        System.out.println("数据2：" + data);
    }
}
