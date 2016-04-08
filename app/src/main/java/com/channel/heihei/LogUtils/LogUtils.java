package com.channel.heihei.LogUtils;

import android.util.Log;

/**
 * Created by SMouse on 2016/1/8.
 */
public class LogUtils {

    public static int VERBOSE = 1;
    public static int DEBUG = 2;
    public static int INFO = 3;
    public static int WARM = 4;
    public static int ERROR = 5;
    public static int NOTHING = 6;

    //定义一个等级，控制LOG的打印级别。如果小于INDEX则不打印。不过INDEX > 7 则所有的LOG全部不打印
    public static int LEVEL = VERBOSE;

    public static void v(String tag,String message)
    {
        if(LEVEL <= VERBOSE )
        {
            Log.v(tag, message);
        }
    }

    public static void d(String tag,String message)
    {
        if(LEVEL <= DEBUG)
        {
            Log.d(tag,message);
        }
    }

    public static void i(String tag,String message)
    {
        if(LEVEL <= INFO)
        {
            Log.i(tag,message);
        }
    }

    public static void w(String tag,String messsage)
    {
        if(LEVEL < WARM)
        {
            Log.w(tag, messsage);
        }
    }

    public static  void e(String tag,String message)
    {
        if(LEVEL < ERROR)
        {
            Log.e(tag, message);
        }
    }

}
