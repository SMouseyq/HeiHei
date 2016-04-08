package com.channel.heihei.view;

import android.content.Context;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.channel.heihei.LogUtils.LogUtils;

/**
 * Created by SMouse on 2016/3/3.
 */
public class HorizontalScrollView extends View implements GestureDetector.OnGestureListener{
    private static final String TAG = "HorizontalScrollView";
    VelocityTracker velocityTracker = null;
    GestureDetector gestureDetector = null;
    Scroller  scroller = null;
    private Context context;
    ViewGroup.MarginLayoutParams lp= null;
    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initData();
    }
    private void initData() {
        if(gestureDetector == null) {
            gestureDetector = new GestureDetector(this);
        }
        if(scroller == null){
            scroller = new Scroller(context);
        }




    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    int initX = 0;
    int initY = 0;
    int marginLeft = 0;
    int marginTop = 0;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        gestureDetector.setIsLongpressEnabled(false);
//        boolean consume  = gestureDetector.onTouchEvent(ev);

        switch(ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtils.i(TAG,"ACTION_DOWN");
                velocityTracker =  VelocityTracker.obtain();
                initX =(int) ev.getRawX();
                initY = (int)ev.getRawY();
                if(lp ==null) {
                    lp = (ViewGroup.MarginLayoutParams)getLayoutParams();
                }

                marginLeft = lp.leftMargin;
                marginTop = lp.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtils.i(TAG,"ACTION_MOVE");
                velocityTracker.addMovement(ev);
                velocityTracker.computeCurrentVelocity(100);
                float xVelocity = velocityTracker.getXVelocity();
                float yVelocity = velocityTracker.getYVelocity();
//                LogUtils.i(TAG,"xVelocity <"+xVelocity +"> yVelocity <"+yVelocity+">");
                int x =  (int)ev.getX();
                int y = (int)ev.getY();
                int rawX = (int)ev.getRawX();
                int rawY = (int) ev.getRawY();

//                scroller.startScroll(getLeft(),getTop(),x,y);

                int pianX =  marginLeft + rawX - initX;
                int pianY =  marginTop + rawY -initY ;
                lp.leftMargin = pianX;
                lp.topMargin  =pianY;
                setLayoutParams(lp);
//                smoothScrollTo(x,y);
//                scrollTo(rawX, rawY);

                break;
            case MotionEvent.ACTION_UP:
                LogUtils.i(TAG,"ACTION_UP");
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtils.i(TAG,"ACTION_CANCEL");
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                LogUtils.i(TAG,"ACTION_POINTER_DOWN");
                break;

        }


//        LogUtils.i(TAG,"rawX<"+rawX+">==rawY <"+rawY+">");
//        LogUtils.i(TAG,"X<"+x+">==Y <"+y+">");

        return true;

//        return super.onTouchEvent(ev);
    }


    private void smoothScrollTo(int destX,int destY) {
        int scrollX = getScrollX();
        int delta = destX-scrollX;
        scroller.startScroll(scrollX,0,delta,0,1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        LogUtils.i(TAG,"onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        LogUtils.i(TAG,"onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        LogUtils.i(TAG,"onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        LogUtils.i(TAG,"onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        LogUtils.i(TAG,"onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        LogUtils.i(TAG,"onFling");
        return false;

    }
}