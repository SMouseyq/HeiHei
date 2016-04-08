package com.channel.heihei.Activitys;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.R;
import com.channel.heihei.Utils.CommonUtils;
import com.channel.heihei.principle.Observer.Observable;
import com.channel.heihei.principle.Observer.Observer;
import com.channel.heihei.principle.Observer.impl.Observable_1;
import com.channel.heihei.principle.Observer.impl.Observer_1;
import com.channel.heihei.principle.Observer.impl.Observer_2;
import com.channel.heihei.principle.Observer.impl.Observer_3;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SMouse on 2016/2/29.
 */
public class SecondActivity extends BaseActivity{

    protected String TAG = "SecondActivity";

    Observable_1 observable ;

    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @OnClick({R.id.button1,R.id.button2,R.id.button3,R.id.button4})
    void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                CommonUtils.toast("button1");
                Intent intent  = new Intent();
                intent.setClass(SecondActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                CommonUtils.toast("button2");
                intent = new Intent();
                intent.setClass(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                CommonUtils.toast("button3");
                intent = new Intent();
                intent.setClass(SecondActivity.this,ForthActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                CommonUtils.a+=1;
                LogUtils.i(TAG,"onCreate CommonUtils.a { " + CommonUtils.a  +" }");
                observable.doSomething();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        ButterKnife.bind(this);
        CommonUtils.getObj();
        LogUtils.i(TAG,"SecondActivity.onCreate");
        LogUtils.i(TAG,"onCreate CommonUtils.a { " + CommonUtils.a  +" }");

        observable = new Observable_1();
        Observer observer_1 = new Observer_1(observable);
        Observer observer_2 = new Observer_2(observable);
        Observer observer_3 = new Observer_3(observable);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG,"SecondActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG,"SecondActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG,"SecondActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(TAG,"SecondActivity.onStop");
        LogUtils.i(TAG,"onStop CommonUtils.a { " + CommonUtils.a  +" }");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG,"SecondActivity.onDestroy");
    }
}
