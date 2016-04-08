package com.channel.heihei.Bean;

import android.text.TextUtils;

/**
 * Created by SMouse on 2016/1/20.
 */
public class Person {

    private String id;
    private String name;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save(String name){
        if(TextUtils.isEmpty(name)) {
           return;
        }
        if(name.length()>6) {
            this.name = name.substring(6);
        }else{
            this.name = name;
        }

    }

    public void addAge(int a, int b){
        this.age = a+b;
    }
    

}
