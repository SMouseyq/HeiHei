package com.channel.heihei.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.R;
import com.channel.heihei.Utils.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SMouse on 2016/2/29.
 */
public class ThirdActivity extends BaseActivity{

    private static final String TAG = "ThirdActivity";

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
                intent.setClass(ThirdActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                CommonUtils.toast("button2");
                intent = new Intent();
                intent.setClass(ThirdActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                CommonUtils.toast("button3");
                intent = new Intent();
                intent.setClass(ThirdActivity.this,ForthActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                CommonUtils.toast("button4");
                intent = new Intent();
                intent.setClass(ThirdActivity.this,SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        ButterKnife.bind(this);
        LogUtils.i(TAG,"ThirdActivity.onCreate ");
        LogUtils.i(TAG,"ThirdActivity.onCreate CommonUtils.a = {" + CommonUtils.a +" }");

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG,"ThirdActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG,"ThirdActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG,"ThirdActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(TAG,"ThirdActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG,"ThirdActivity.onDestroy");
    }
}
