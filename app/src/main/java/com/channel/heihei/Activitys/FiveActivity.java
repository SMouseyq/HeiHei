package com.channel.heihei.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.view.Window;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.R;
import com.channel.heihei.app.MyApp;

/**
 * 水平滑动  View
 * Created by SMouse on 2016/3/3.
 */
public class FiveActivity extends BaseActivity{

    private static final String TAG = "FiveActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_five);
        int slop = ViewConfiguration.get(this).getScaledTouchSlop();
        LogUtils.i(TAG,"slop<" + slop +">");
    }
}