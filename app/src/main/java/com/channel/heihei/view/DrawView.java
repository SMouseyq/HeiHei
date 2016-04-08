package com.channel.heihei.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SMouse on 2016/3/4.
 */
public class DrawView  extends TextView {
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    Paint paint = null;
    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
//        arcPaint.setStyle(Paint.Style.FILL);
//        arcPaint.setColor(Color.RED);
//        arcPaint.setTextSize(50);

//        canvas.drawRect(rect, arcPaint);
//        canvas.drawLine(0,0,100,100,arcPaint);
//
//        float [] lines = {
//                0,100,0,100,
//                100,300,100,100,
//                300,500,100,500
//        };
//        canvas.drawLines(lines,paint);
        paint.setColor(Color.BLACK);                    //设置画笔颜色
        float[] pts={0,100,200,100,
                200,100,50,200,
                50,200,100,0,
                100,0,200,200,
                200,200,0,100
               };                  //数据

        canvas.drawColor(Color.WHITE);                  //白色背景
        paint.setStrokeWidth((float) 5.0);  //线宽
        canvas.drawLines(pts, paint);
        RectF rect = new RectF();
        rect.set(0,0,300,300);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rect,50f,50f,paint);
        canvas.drawCircle(100,100,100f,paint);
        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);
        super.onDraw(canvas);
    }
}
