package com.channel.heihei.principle.Observer.impl;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.principle.Observer.Observable;

/**
 * Created by SMouse on 2016/3/29.
 */
public class Observable_1 extends Observable{

    private String name;
    private int age;
    public void doSomething() {
        LogUtils.i(TAG, "{我是Observable_1,我的状态改变了 我要广播了}");
        setNotice(true);
        notice();
        setNotice(false);
    }

    public String getMyName(){
        return name;
    }
    public void setMyName(String name ) {
        this.name = name;
        doSomething();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        doSomething();
    }
}
