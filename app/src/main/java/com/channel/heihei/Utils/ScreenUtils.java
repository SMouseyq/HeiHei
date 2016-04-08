package com.channel.heihei.Utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 屏幕中 单位转换，获取屏幕数据
 * Created by fangyq on 2016/3/4.
 */
public class ScreenUtils {
    /**
     * 将px 转换成dp
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context,float px) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return (int)(px/scale+0.5f);
    }

    /**
     * 将dp转换成px
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return (int)(dp*scale + 0.5f);
    }

    /**
     * 将px 转换成 sp
     * @param context
     * @param px
     * @return
     */
    public static int px2sp(Context context,float px) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int)(px/fontScale + 0.5f);
    }

    /**
     * sp转换成px
     * @param context
     * @param sp
     * @return
     */
    public static int sp2px(Context context ,float sp) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int)(sp*fontScale +0.5f);
    }

    /**
     * 使用 TypedValue 将dp转换成px
     * @param dp
     * @param context
     * @return
     */
    public static int dp2px(float dp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }

    /**
     * 使用 TypedValues 将sp转换成 px
     * @param sp
     * @param context
     * @return
     */
    public static int sp2px(float sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,context.getResources().getDisplayMetrics());
    }
}
