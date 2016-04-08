package com.channel.heihei.Activitys;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.R;
import com.channel.heihei.Utils.CommonUtils;
import com.channel.heihei.http.OnHttpRequest;
import com.channel.heihei.http.impl.onHttpRequestImpl;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    public String TAG = "MainActivity";

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
                CommonUtils.a += 1;
                LogUtils.i(TAG,"button1 CommonUtils.a = { " + CommonUtils.a +" }");
                Intent intent  = new Intent();
                intent.setClass(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                CommonUtils.toast("button2");
                intent = new Intent();
                intent.setClass(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                CommonUtils.toast("button3");
                intent = new Intent();
                intent.setClass(MainActivity.this,ForthActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                CommonUtils.toast("button4");
                intent = new Intent();
                intent.setClass(MainActivity.this,FiveActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CommonUtils.getObj();
        LogUtils.i(TAG,"MainActivity.onCreate");
        LogUtils.i(TAG,"onCreate CommonUtils.a = {" + CommonUtils.a +" }") ;
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG,"MainActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG,"MainActivity.onResume");
        LogUtils.i(TAG," onResume CommonUtils.a = { " + CommonUtils.a +" }");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG,"MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(TAG,"MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG,"MainActivity.onDestroy");
    }
    public int add(int a,int b) {
        return a+b;
    }
}
