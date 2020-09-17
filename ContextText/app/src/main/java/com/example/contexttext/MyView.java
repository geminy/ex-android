package com.example.contexttext;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Log.d("ContextText", "MyView param context:" + context);
        Log.d("ContextText", "MyView this:" + this);
        Log.d("ContextText", "MyView getContext:" + getContext());
    }
}
