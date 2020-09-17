package com.example.contexttext;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
    public MyApplication() {
        super();
        try {
            Log.d("ContextText", "MyApplication this:" + this);
            Log.d("ContextText", "MyApplication getBaseContext:" + getBaseContext());
            Log.d("ContextText", "MyApplication getApplicationContext:" + getApplicationContext());
        } catch (Exception e) {
            Log.d("ContextText", "Exception:" + e);
        }
    }
}
