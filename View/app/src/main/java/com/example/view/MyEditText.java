package com.example.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MyEditText extends EditText {
    private static final String TAG = "ViewTest";

    public MyEditText(Context context) {
        this(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
//        requestFocus();
        Log.d(TAG, "MyEditText----------" + this);
        Log.d(TAG, "MyEditText isFocusable:" + isFocusable());
        Log.d(TAG, "MyEditText isFocusableInTouchMode:" + isFocusableInTouchMode());
        Log.d(TAG, "MyEditText isFocused:" + isFocused());
        Log.d(TAG, "MyEditText isFocusedByDefault:" + isFocusedByDefault());
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        Log.d(TAG, "MyEditText onFocusChanged----------" + this);
        Log.d(TAG, "MyEditText onFocusChanged focused:" + focused
                + " direction:" + direction + " previouslyFocusedRect:" + previouslyFocusedRect);
//        Log.d(TAG, "MyEditText onFocusChanged isFocusable:" + isFocusable());
//        Log.d(TAG, "MyEditText onFocusChanged isFocusableInTouchMode:" + isFocusableInTouchMode());
//        Log.d(TAG, "MyEditText onFocusChanged isFocused:" + isFocused());
//        Log.d(TAG, "MyEditText onFocusChanged isFocusedByDefault:" + isFocusedByDefault());
//        setVisibility(View.INVISIBLE);
//        requestFocus(View.FOCUS_DOWN);
//        clearFocus();
//        Log.d(TAG, "MyEditText onFocusChanged findFocus:" + findFocus());
//        Log.d(TAG, "MyEditText onFocusChanged focusSearch:" + focusSearch(View.FOCUS_DOWN));
//        Log.d(TAG, "MyEditText onFocusChanged getNextFocusDownId:" + getNextFocusDownId());
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.d(TAG, "MyEditText onWindowFocusChanged----------" + this);
        Log.d(TAG, "MyEditText onWindowFocusChanged hasWindowFocus:" + hasWindowFocus);
    }
}
