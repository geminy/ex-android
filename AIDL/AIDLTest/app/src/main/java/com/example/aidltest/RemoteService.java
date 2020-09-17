// RemoteService.java
package com.example.aidltest;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class RemoteService extends Service {
    private IRemoteServiceCallback mCallback;

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public int add(int a, int b) {
            int ret = a + b;
            Log.d("RemoteService", "add ret:" + ret);
            return ret;
        }

        @Override
        public void print(String string) {
            Log.d("RemoteService", "print string:" + string);
        }

        @Override
        public void printUser(User user) {
            Log.d("RemoteService", "printUser user:" + user);
            try {
                if (null != mCallback) {
                    mCallback.hello(111);
                }
            } catch (Exception e) {
                Log.d("RemoteService", "callback Exception:" + e);
            }
        }

        @Override
        public void printUser2(User user) {
            Log.d("RemoteService", "printUser2 user:" + user);
            try {
                if (null != mCallback) {
                    mCallback.hello(222);
                }
            } catch (Exception e) {
                Log.d("RemoteService", "callback Exception:" + e);
            }
        }

        @Override
        public void printUser3(User user) {
            Log.d("RemoteService", "printUser3 user:" + user);
            try {
                if (null != mCallback) {
                    mCallback.hello(333);
                }
            } catch (Exception e) {
                Log.d("RemoteService", "callback Exception:" + e);
            }
        }

        @Override
        public void registerCallback(IRemoteServiceCallback callback) {
            Log.d("RemoteService", "registerCallback callback:" + callback);
            mCallback = callback;
        }
    };

    public RemoteService() {
        Log.d("RemoteService", "RemoteService");
    }

    @Override
    public void onCreate() {
        Log.d("RemoteService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        Log.d("RemoteService", "onStartCommand intent:" + intent);
        Log.d("RemoteService", "onStartCommand flags:" + flags);
        Log.d("RemoteService", "onStartCommand startId:" + startId);
        Log.d("RemoteService", "onStartCommand ret:" + ret);
        return ret;
    }

    @Override
    public void onDestroy() {
        Log.d("RemoteService", "onDestroy");
        mCallback = null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("RemoteService", "onConfigurationChanged newConfig:" + newConfig);

    }

    @Override
    public void onLowMemory() {
        Log.d("RemoteService", "onLowMemory");

    }

    @Override
    public void onTrimMemory(int level) {
        Log.d("RemoteService", "onTrimMemory level:" + level);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("RemoteService", "onBind intent:" + intent);
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("RemoteService", "onUnbind intent:" + intent);
        mCallback = null;
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("RemoteService", "onRebind intent:" + intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d("RemoteService", "onTaskRemoved intent:" + rootIntent);
    }
}
