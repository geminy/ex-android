package com.example.databinding;

import android.util.Log;
import android.view.View;

import static com.example.databinding.MainActivity.TAG;

public class MyHandlers {
    public MyHandlers() {
        Log.d(TAG, "MyHandlers");
    }

    public void handleOnClick(View view) {
        Log.d(TAG, "MyHandlers handleOnClick");
    }
}
