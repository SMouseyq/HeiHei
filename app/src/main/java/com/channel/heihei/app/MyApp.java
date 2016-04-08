package com.channel.heihei.app;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.channel.heihei.BuildConfig;

import timber.log.Timber;

/**
 * Created by SMouse on 2016/1/7.
 */
public class MyApp extends Application {
    private static String ANDROID_VERSION = null;
    private static String PHONE_MODEL = null;
    private static String PHONE_MANUFACTURER = null;
    public static String DEVICE_INFO = null;
    public static String APP_INFO = null;
    private static String APP_PACKAGE = null;
    public static String APP_VERSION = null;
    public static int APP_VERSION_CODE = 0;

    private static MyApp instance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        //在这里初始化
        instance = this;
        initLog();
        initConstants();
        initBugTags();

//        Bugtags.start("d13ec2b210da876bafebd2faa36c0ff7", this, Bugtags.BTGInvocationEventBubble);
    }
    private void initLog() {
        Timber.plant(new Timber.DebugTree());
    }
    private void initBugTags() {
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(true).//是否获取位置
                trackingCrashLog(true).//是否收集crash
                trackingConsoleLog(true).//是否收集console log
                trackingUserSteps(true).//是否收集用户操作步骤
                crashWithScreenshot(true).//crash附带图
                versionName(APP_VERSION).//自定义版本名称
                versionCode(APP_VERSION_CODE).//自定义版本号
                build();
        if (BuildConfig.DEBUG) {
            Bugtags.start(CommonConstants.BUG_TAGS_APP_KEY, this, Bugtags.BTGInvocationEventBubble, options);
        } else {
            Bugtags.start(CommonConstants.BUG_TAGS_APP_KEY, this, Bugtags.BTGInvocationEventNone, options);
        }
    }

    private void initConstants() {
        ANDROID_VERSION = android.os.Build.VERSION.RELEASE;
        PHONE_MODEL = android.os.Build.MODEL;
        PHONE_MANUFACTURER = android.os.Build.MANUFACTURER;

        StringBuilder sb = new StringBuilder();
        sb.append("|  PHONE_MANUFACTURER: ").append(PHONE_MANUFACTURER).append("|\n").append("|  PHONE_MODEL       : ").append(PHONE_MODEL).append(" |\n").append("|  ANDROID_VERSION   : ").append(ANDROID_VERSION).append(" |\n");
        DEVICE_INFO = sb.toString();

        PackageManager packageManager = this.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    this.getPackageName(), 0);
            APP_VERSION = packageInfo.versionName;
            APP_VERSION_CODE = packageInfo.versionCode;
            APP_PACKAGE = packageInfo.packageName;

            sb = new StringBuilder();
            sb.append("|  APP_PACKAGE: ").append(APP_PACKAGE).append(" |\n").append("|  APP_VERSION: ").append(APP_VERSION).append("                |\n");
            APP_INFO = sb.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Timber.d("====================\n======== device-info =========\n%s========= app-info ==========\n%s =============================\n", DEVICE_INFO, APP_INFO);
    }
    public static MyApp getInstance() {
        return instance;
    }
}
