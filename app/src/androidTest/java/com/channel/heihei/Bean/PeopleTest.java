package com.channel.heihei.Bean;

import android.test.AndroidTestCase;

/**
 * Created by SMouse on 2016/1/20.
 */
public class PeopleTest  extends AndroidTestCase{

    Person person = null;

    @Override
    protected void setUp(){

        try{
            super.setUp();
        }catch(Exception e) {
            e.printStackTrace();
        }
        person = new Person();

    }

    @Override
    protected void tearDown() {
        try{
            super.tearDown();
        }catch(Exception e) {
            e.printStackTrace();
        }
        person = null;

    }
    public void testSave() {
        person.save("null is me");
        assertEquals("s me" ,person.getName());
    }
    public void testSetAddGetName(){
        person.setName("SMouse");
        String name = person.getName();
        assertEquals("SMouse",name);
    }
    public void testSetAddGetId() {
        person.setId("123123");
        String id = person.getId();
        assertEquals("123123",id);
    }
    public void testAddAge(){
        person.addAge(12,12);
        int age = person.getAge();
        assertEquals(24,age);
    }

}



