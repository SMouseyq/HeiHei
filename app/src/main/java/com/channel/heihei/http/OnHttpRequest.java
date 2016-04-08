package com.channel.heihei.http;

import rx.Subscriber;

/**
 * Created by SMouse on 2016/1/20.
 */
public interface OnHttpRequest {

    void getSomething(String id, Subscriber<String> subscriber);

}
