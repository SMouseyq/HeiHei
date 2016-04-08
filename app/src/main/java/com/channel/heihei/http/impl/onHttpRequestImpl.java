package com.channel.heihei.http.impl;

import com.channel.heihei.http.OnHttpRequest;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by SMouse on 2016/1/20.
 */
public class onHttpRequestImpl implements OnHttpRequest{
    @Override
    public void getSomething(String id, Subscriber<String> subscriber) {

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("获取的数据");
                subscriber.onCompleted();
//              subscriber.onError(new Throwable());
            }
        });
        observable.subscribe(subscriber);

    }
}
