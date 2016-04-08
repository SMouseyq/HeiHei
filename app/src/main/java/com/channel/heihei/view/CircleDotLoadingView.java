package com.channel.heihei.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.channel.heihei.R;

import java.util.Timer;
import java.util.TimerTask;

import timber.log.Timber;

/**
 * Created by SMouse on 2016/1/25.
 */
public class CircleDotLoadingView extends View{

    private static final String TAG = "CircleDotLoadingView";

    public static final boolean STATE_ING = true;
    public static final boolean STATE_INIT= false;
    private boolean state = false;
    Paint   circlePaint =null;
    private int mColor;    //主颜色
    private int cx =0;
    private int cy =0;
    private int mCircleRadius; //圆圈的半径
    private float mCircleStrokeWidth;  //圆圈的厚度

    Paint dotPaint = null;
    private float  dotX =0;
    private float  dotY =0;
    private float mDotRadius =0;
    Interpolator mInterpolator =null;
    private int linearAngle = 0; //线性角度变化值:0-360

    private int MIN_SIZE = 6;

    public CircleDotLoadingView(Context context) {
        super(context);
        Timber.d("CircleDotLoadingView(Context context)");
        init();
    }

    public CircleDotLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Timber.d("CircleDotLoadingView(Context context, AttributeSet attrs)");
        init();
    }

    public CircleDotLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Timber.d("CircleDotLoadingView(Context context, AttributeSet attrs, int defStyleAttr)");
        init();
    }

    public CircleDotLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Timber.d("CircleDotLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)");
        init();
    }
    private void init() {
        mCircleStrokeWidth = getContext().getResources().getDimension(R.dimen.circle_stroke_width); //圆圈的厚度和感叹号的厚度
        mDotRadius = getContext().getResources().getDimension(R.dimen.dot_radio); //圆圈的厚度和感叹号的厚度
        mColor = getContext().getResources().getColor(R.color.loading_dot);

        circlePaint = new Paint();
        circlePaint.setColor(mColor); //颜色
        circlePaint.setAntiAlias(true); //抗锯齿
        circlePaint.setStrokeWidth(mCircleStrokeWidth); //stroke的宽度
        circlePaint.setStyle(Paint.Style.STROKE); //stroke模式

        dotPaint= new Paint(); //其实是定义为了成员变量，这里为了看着方便
        dotPaint.setAntiAlias(true);
        dotPaint.setColor(mColor);
        dotPaint.setStyle(Paint.Style.FILL);

        mInterpolator= new AccelerateDecelerateInterpolator();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(MIN_SIZE, MIN_SIZE);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(MIN_SIZE, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, MIN_SIZE);
        }
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        /*注意,绘制的坐标是以当前View的左上角为圆点的,而不是当前View的坐标*/
        //圆心坐标计算
        cx = (getWidth() + getPaddingLeft() - getPaddingRight()) / 2;
        cy = (getHeight() + getPaddingTop() + -getPaddingBottom()) / 2;
        //圆圈的半径计算
        int radiusH = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2 - (int) mDotRadius;
        int radiusV = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2 - (int) mDotRadius;
        //半径是两者中的最小值
        mCircleRadius = Math.min(radiusV, radiusH);

        dotX = cx;
        dotY = getPaddingTop() + mDotRadius * 2;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, mCircleRadius, circlePaint);
        if(state!=STATE_INIT){
            canvas.drawCircle(dotX, dotY, mDotRadius, dotPaint);
        }
    }
    /**
     * 刷新dot位置
     */
    private void refreshDotPosition() {
        final float input = (linearAngle % 360.0F); //[0,1]
        float f = mInterpolator.getInterpolation(input / 360.0F);  //[0-1]
        double realAngle = f * 2 * Math.PI; //真实的角度,[0-2π]的范围
        dotX = cx + (float) (mCircleRadius * Math.sin(realAngle));
        dotY = cy - (float) (mCircleRadius * Math.cos(realAngle));
        postInvalidate();
        linearAngle = linearAngle + 1;
    }
    //定时器
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            refreshDotPosition();
        }
    };
    //调用这个方法开始loading动画
    public void startLoading() {
        timer.schedule(timerTask, 10, 3);
        state = STATE_ING;
    }
}
