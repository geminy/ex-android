package com.example.testsystemui;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class App extends Application {
    private static final String TAG_CLASS_NAME = "App";

    private ActivityLifecycleCallbacks mActivityLifecycleCallback = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            MyLog.output(TAG_CLASS_NAME, "onActivityCreated", "activity:" + activity);
            MyLog.output(TAG_CLASS_NAME, "onActivityCreated", "bundle:" + bundle);
        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {
            MyLog.output(TAG_CLASS_NAME, "onActivityStarted", "activity:" + activity);
        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {
            MyLog.output(TAG_CLASS_NAME, "onActivityResumed", "activity:" + activity);
        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {
            MyLog.output(TAG_CLASS_NAME, "onActivityPaused", "activity:" + activity);
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {
            MyLog.output(TAG_CLASS_NAME, "onActivityStopped", "activity:" + activity);
        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {
            MyLog.output(TAG_CLASS_NAME, "onActivityDestroyed", "activity:" + activity);
        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            MyLog.output(TAG_CLASS_NAME, "onActivitySaveInstanceState", "activity:" + activity);
            MyLog.output(TAG_CLASS_NAME, "onActivitySaveInstanceState", "bundle:" + bundle);
        }
    };

    public App() {
        super();
        MyLog.output(TAG_CLASS_NAME, "App", "");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.output(TAG_CLASS_NAME, "onCreate", "");
        registerActivityLifecycleCallbacks(mActivityLifecycleCallback);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        MyLog.output(TAG_CLASS_NAME, "onTerminate", "");
        unregisterActivityLifecycleCallbacks(mActivityLifecycleCallback);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MyLog.output(TAG_CLASS_NAME, "onConfigurationChanged", "newConfig:" + newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MyLog.output(TAG_CLASS_NAME, "onLowMemory", "");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MyLog.output(TAG_CLASS_NAME, "onTrimMemory", "level:" + level);
    }
}
