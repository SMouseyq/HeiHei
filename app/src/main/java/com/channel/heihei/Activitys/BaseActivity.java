package com.channel.heihei.Activitys;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.MotionEvent;

import com.bugtags.library.Bugtags;
import com.channel.heihei.LogUtils.LogUtils;

import java.security.AccessControlContext;
import java.util.List;

/**
 * Created by SMouse on 2016/1/7.
 */
public class BaseActivity extends Activity{

    public String TAG = "BaseActivity";
    ActivityManager manager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        logActivityTaskInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注：回调 1
        Bugtags.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //注：回调 2
        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //注：回调 3
        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }
    public void logActivityTaskInfo() {
        List<ActivityManager.RunningTaskInfo> infos = manager.getRunningTasks(1);
        if(infos!=null) {
            for(int i =0 ;i< infos.size();i++) {
                ActivityManager.RunningTaskInfo info  =  infos.get(i);
                LogUtils.i(TAG, "position<"+i+"> RunningTaskInfo <"+ info.toString() +">");
                LogUtils.i(TAG, "topActivity <" + infos.get(0).topActivity.toString() +">");
            }
        }
    }
}