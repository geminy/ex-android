package com.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {
    private static final String TAG = "ViewTest";

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        String name = array.getString(R.styleable.CustomView_name);
        int age = array.getInt(R.styleable.CustomView_number, 0);
        array.recycle();
        Log.d(TAG, "CustomView name:" + name);
        Log.d(TAG, "CustomView number:" + age);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "CustomView onFinishInflate");
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.d(TAG, "CustomView onVisibilityChanged changedView:" + changedView + " visibility:" + visibility);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.d(TAG, "CustomView onWindowVisibilityChanged visibility:" + visibility);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "CustomView onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "CustomView onDetachedFromWindow");
    }
}
