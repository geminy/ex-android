package com.example.animation;

import android.util.Log;

public class MyLog {
    private static final String TAG_LOG = "Animation";
    private static final String TAG_SEPARATOR = "$";

    public static void output(String className, String methodName, String message) {
        StringBuilder msg = new StringBuilder(className);
        msg.append(TAG_SEPARATOR);
        msg.append(methodName);
        msg.append(TAG_SEPARATOR);
        msg.append(message);
        Log.d(TAG_LOG, msg.toString());
    }
}
