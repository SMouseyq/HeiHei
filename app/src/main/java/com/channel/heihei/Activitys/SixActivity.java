package com.channel.heihei.Activitys;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewConfiguration;

import com.channel.heihei.LogUtils.LogUtils;
import com.channel.heihei.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 水平滑动  View
 * Created by SMouse on 2016/3/3.
 */
public class SixActivity extends BaseActivity{

    private static final String TAG = "SixActivity";

    @Bind(R.id.id_navigationview)
    NavigationView id_navigationview ;

    @Bind(R.id.id_coordinatorlayout)
    CoordinatorLayout id_coordinatorlayout;

    @Bind(R.id.id_appbarlayout)
    AppBarLayout id_appbarlayout;

    @Bind(R.id.id_toolbar)
    Toolbar id_toolbar;

    @Bind(R.id.id_tablayout)
    TabLayout id_tablayout;

    @Bind(R.id.id_viewpager)
    ViewPager id_viewpager;

    @Bind(R.id.id_floatingactionbutton)
    FloatingActionButton id_floatingactionbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_six);
        ButterKnife.bind(this);
        int slop = ViewConfiguration.get(this).getScaledTouchSlop();
        LogUtils.i(TAG,"slop<" + slop +">");


    }
}