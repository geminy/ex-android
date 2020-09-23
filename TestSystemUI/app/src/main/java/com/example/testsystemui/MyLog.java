package com.example.testsystemui;

import android.util.Log;

public class MyLog {
    private static final String TAG_LOG = "TestSystemUI";
    private static final String TAG_SEPARATOR = "$";

    public static void output(String className, String methodName, String message) {
        String msg = className + TAG_SEPARATOR + methodName + TAG_SEPARATOR + message;
        Log.d(TAG_LOG, msg);
    }
}
