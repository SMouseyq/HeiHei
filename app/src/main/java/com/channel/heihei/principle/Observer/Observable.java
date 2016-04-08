package com.channel.heihei.principle.Observer;

import java.util.Vector;

/**
 * Created by SMouse on 2016/3/28.
 */
public class Observable {
    protected String TAG = getClass().getSimpleName();
    private Vector<Observer> vector = new Vector<>();
    private boolean isNotice = false;

    public void register(Observer observer){
        vector.add(observer);
    }
    public void unregister(Observer observer){
        vector.remove(observer);
    }
    protected void notice() {
        if(vector.size()==0){
            return; //没有可通知的
        }
        if(!isNotice){
            return;// 没达到要通知的程度
        }
        for(Observer v :vector){
            v.update(this,"");
        }
    }
    protected void setNotice(boolean isNotice){
        this.isNotice = isNotice;
    }
    protected boolean isNotice(){
        return isNotice;
    }


}