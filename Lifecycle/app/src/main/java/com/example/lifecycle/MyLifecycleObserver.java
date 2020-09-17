package com.example.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {
    private static LifecycleObserver sObserver;

    private MyLifecycleObserver() {
        Log.d("Lifecycle", "MyLifecycleObserver");
    }

    public static LifecycleObserver getObserver() {
        if (sObserver == null) {
            sObserver = new MyLifecycleObserver();
        }
        return sObserver;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        Log.d("Lifecycle", "MyLifecycleObserver create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        Log.d("Lifecycle", "MyLifecycleObserver start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        Log.d("Lifecycle", "MyLifecycleObserver resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        Log.d("Lifecycle", "MyLifecycleObserver pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.d("Lifecycle", "MyLifecycleObserver stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        Log.d("Lifecycle", "MyLifecycleObserver destroy");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void any() {
        Log.d("Lifecycle", "MyLifecycleObserver any");
    }
}
