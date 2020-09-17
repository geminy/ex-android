package com.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.AbsoluteLayout;

public class ScrollLayout extends AbsoluteLayout {
    private static final String TAG = "ViewTest";

    public ScrollLayout(Context context) {
        this(context, null);
    }

    public ScrollLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.d(TAG, "ScrollLayout onScrollChanged:" + l + " " + t + " " + oldl + " " + oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "ScrollLayout onTouchEvent");
        scrollBy(10, 15);
        return true;
    }

    @Override
    public boolean awakenScrollBars() {
        Log.d(TAG, "ScrollLayout awakenScrollBars");
        return false;
    }

    @Override
    public void postInvalidateOnAnimation() {
        super.postInvalidateOnAnimation();
        Log.d(TAG, "ScrollLayout postInvalidateOnAnimation");
    }
}
