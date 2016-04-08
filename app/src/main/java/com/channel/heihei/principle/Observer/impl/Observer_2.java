package com.channel.heihei.principle.Observer.impl;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.Utils.CommonUtils;
import com.channel.heihei.principle.Observer.Display;
import com.channel.heihei.principle.Observer.Observable;
import com.channel.heihei.principle.Observer.Observer;

/**
 * Created by SMouse on 2016/3/28.
 */
public class Observer_2 implements Observer,Display {

    Observable observable = null;

    public Observer_2(Observable observable) {
        this.observable = observable;
        observable.register(this);
    }
    @Override
    public void update(Observable observable, Object obj) {
        display();

    }
    @Override
    public void display() {
        LogUtils.i(TAG, "{我是Observer_2,我收到通知了} {他告诉我他叫“" + "" + "” 我们是朋友");
    }
}