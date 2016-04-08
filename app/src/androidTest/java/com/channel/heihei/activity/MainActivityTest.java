package com.channel.heihei.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.channel.heihei.Activitys.MainActivity;
import com.channel.heihei.R;

/**
 * Created by SMouse on 2016/1/20.
 */
public class MainActivityTest extends InstrumentationTestCase{

    private MainActivity mainActivity = null;
    private Button button = null;
    private TextView textView = null;

    @Override
    protected void setUp(){
        try{
            super.setUp();
        }catch (Exception e){
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.channel.heihei",MainActivity.class.getName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mainActivity = (MainActivity)getInstrumentation().startActivitySync(intent);
        button = (Button)mainActivity.findViewById(R.id.button1);

    }

    @Override
    protected void tearDown(){
        mainActivity.finish();

        try{
            super.tearDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void testActivity() {
        try{
            Log.v("testActivity", "test the Activity");
            SystemClock.sleep(1500);
            getInstrumentation().runOnMainSync(new PerformClick(button));

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
//    public void testAdd() {
//        try{
//            int test = mainActivity.add(1,1);
//            assertEquals(2,test);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
    private class PerformClick implements Runnable{

        Button btn;
        public PerformClick( Button btn) {
            this.btn = btn;
        }
        @Override
        public void run() {
            btn.performClick();
        }
    }
    public void testAdd() {
        String testTag = "textAdd";
        Log.e(testTag,"test add method");
        try{
            int test = mainActivity.add(1,1);
            assertEquals(2,test);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
