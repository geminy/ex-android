// LocalService.java
package com.example.aidltest;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class LocalService extends Service {
    private final ILocalService.Stub mBinder = new ILocalService.Stub() {
        @Override
        public int getPid() {
            int pid = Process.myPid();
            Log.d("LocalService", "getPid pid:" + pid);
            return pid;
        }

        @Override
        public int getTid() {
            int tid = Process.myTid();
            Log.d("LocalService", "getTid tid:" + tid);
            return tid;
        }

        @Override
        public void sendMessage(String message) {
            Log.d("LocalService", "sendMessage message:" + message);
        }
    };

    public LocalService() {
        Log.d("LocalService", "LocalService");
    }

    @Override
    public void onCreate() {
        Log.d("LocalService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        Log.d("LocalService", "onStartCommand intent:" + intent);
        Log.d("LocalService", "onStartCommand flags:" + flags);
        Log.d("LocalService", "onStartCommand startId:" + startId);
        Log.d("LocalService", "onStartCommand ret:" + ret);
        return ret;
    }

    @Override
    public void onDestroy() {
        Log.d("LocalService", "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("LocalService", "onConfigurationChanged newConfig:" + newConfig);

    }

    @Override
    public void onLowMemory() {
        Log.d("LocalService", "onLowMemory");

    }

    @Override
    public void onTrimMemory(int level) {
        Log.d("LocalService", "onTrimMemory level:" + level);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("LocalService", "onBind intent:" + intent);
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("LocalService", "onUnbind intent:" + intent);
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("LocalService", "onRebind intent:" + intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d("LocalService", "onTaskRemoved intent:" + rootIntent);
    }
}
