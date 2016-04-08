package com.channel.heihei.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SMouse on 2016/1/25.
 */
public class HorizontalView extends ViewGroup{
    public HorizontalView(Context context) {
        super(context);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode= MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        if(getChildCount()==0) {
            setMeasuredDimension(0,0);
        }else if(widthMode == MeasureSpec.AT_MOST&&heightMode == MeasureSpec.AT_MOST) {
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            int childHeight= childOne.getMeasuredHeight();

            setMeasuredDimension(childWidth*getChildCount(),childHeight);
        }else if(widthMode == MeasureSpec.AT_MOST) {
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth*getChildCount(),heightSize);
        }else if(heightMode == MeasureSpec.AT_MOST) {
            int childHeight = getChildAt(0).getMeasuredHeight();
            setMeasuredDimension(widthSize,childHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = 0;//左边的距离
        View child;
        for(int i =0;i<childCount;i++){
            child = getChildAt(i);
            int width = child.getMeasuredWidth();
            child.layout(left,0,left + width,child.getMeasuredHeight());
            left+=width;
        }

    }
}
