package com.balloon.core.observer.test;

import com.balloon.core.observer.ConcreteSubject;
import com.balloon.core.observer.ObFactory;
import com.balloon.core.observer.Subject;
import com.balloon.core.observer.SubjectStatusEnums;

import java.util.concurrent.ExecutionException;

public class Client  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ConcreteSubject<String> testSubject = new ConcreteSubject<>();
        ConcreteSubject orGenerate = (ConcreteSubject)ObFactory.getOrCreate("123");
        ObFactory.getOrCreate("234");
//        ObFactory.generateSubject("1111");
        Test2Observer test2Observer = new Test2Observer("第二个观察者");
        TestObserver testObserver = new TestObserver("第一个观察者");
        orGenerate.add(test2Observer);
        orGenerate.add(testObserver);
        orGenerate.notifyObservers("liao");
        orGenerate.changeAndNotifyObservers("liao", SubjectStatusEnums.NOTIFY.getCode());
        Subject subject = ObFactory.get("123");
        subject.notifyObservers(1);
//        ObFactory.removeAll();
        System.out.println("主题是："+ObFactory.get("234"));
        System.out.println(SubjectStatusEnums.getMsg(orGenerate.getStatus()));
        System.out.println(test2Observer.getName());
    }
}
