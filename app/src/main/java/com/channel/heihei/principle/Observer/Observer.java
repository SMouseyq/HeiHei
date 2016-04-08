package com.channel.heihei.principle.Observer;

/**
 * Created by SMouse on 2016/3/28.
 */
public interface Observer {
    String TAG = "Observer";
    void update(Observable observable,Object obj);

}
