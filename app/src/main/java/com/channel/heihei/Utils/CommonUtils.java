package com.channel.heihei.Utils;

import android.widget.Toast;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.app.MyApp;
import com.channel.heihei.principle.Observer.Observable;
import com.channel.heihei.principle.Observer.impl.Observable_1;

/**
 * Created by SMouse on 2016/2/29.
 */
public class CommonUtils {
    private static String TAG ="CommonUtils";
    public static int a = 1;
    private int age = 10;
    public static void toast(String content){
        Toast.makeText(MyApp.getInstance(),content,Toast.LENGTH_LONG).show();

    }

    static {
        LogUtils.i(TAG , "静态初始块");
    }
    {
        age = 100;
        LogUtils.i(TAG , "动态初始块");
    }
    public CommonUtils() {
        LogUtils.i(TAG , "构造函数");
    }
    public static void getObj() {
        Observable_1 a =  new Observable_1();
        LogUtils.i(TAG , "getObj {"+a.toString()+"}");
    }
}