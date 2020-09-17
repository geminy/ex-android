// MainActivity.java
package com.example.aidltest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private static final int HELLO = 0;

    private ILocalService mLocalService;

    private final ServiceConnection mLocalConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.d("MainActivity", "onServiceConnected className:" + className);
            Log.d("MainActivity", "onServiceConnected service:" + service);
            mLocalService = ILocalService.Stub.asInterface(service);
            if (null != mLocalService) {
                try {
                    Log.d("MainActivity", "local pid:" + Process.myPid() + "/tid:" + Process.myTid());
                    Log.d("MainActivity", "remote getPid:" + mLocalService.getPid());
                    Log.d("MainActivity", "remote getTid:" + mLocalService.getTid());
                    mLocalService.sendMessage("Called from client");
                } catch (Exception e) {
                    Log.d("MainActivity", "Remote Exception:" + e);
                }
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.d("MainActivity", "onServiceDisconnected className:" + className);
            mLocalService = null;
        }

        @Override
        public void onBindingDied(ComponentName name) {
            Log.d("MainActivity", "onBindingDied className:" + name);
        }

        @Override
        public void onNullBinding(ComponentName name) {
            Log.d("MainActivity", "onNullBinding className:" + name);
        }
    };

    private IRemoteService mRemoteService;

    private final ServiceConnection mRemoteConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.d("MainActivity", "onServiceConnected className:" + className);
            Log.d("MainActivity", "onServiceConnected service:" + service);
            mRemoteService = IRemoteService.Stub.asInterface(service);
            if (null != mRemoteService) {
                try {
                    mRemoteService.registerCallback(mRemoteServiceCallback);
                    Log.d("MainActivity", "add:" + mRemoteService.add(100, 200));
                    mRemoteService.print("Called from client");
                    User user = new User("AAA", 111);
                    mRemoteService.printUser(user);
                    mRemoteService.printUser2(user);
                    mRemoteService.printUser3(user);
                    Log.d("MainActivity", "User:" + user);
                } catch (Exception e) {
                    Log.d("MainActivity", "Remote Exception:" + e);
                }
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.d("MainActivity", "onServiceDisconnected className:" + className);
            mRemoteService = null;
        }

        @Override
        public void onBindingDied(ComponentName name) {
            Log.d("MainActivity", "onBindingDied className:" + name);
        }

        @Override
        public void onNullBinding(ComponentName name) {
            Log.d("MainActivity", "onNullBinding className:" + name);
        }
    };

    private IRemoteServiceCallback mRemoteServiceCallback = new IRemoteServiceCallback.Stub() {
        @Override
        public void hello(int flag) {
            Log.d("MainActivity", "hello flag:" + flag);
            mRemoteServiceHandler.sendMessage(mRemoteServiceHandler.obtainMessage(HELLO, flag));
        }
    };

    private Handler mRemoteServiceHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case HELLO:
                    Log.d("MainActivity", "handleMessage hello flag:" + msg.arg1);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onDestroy();
        Log.d("MainActivity", "onConfigurationChanged newConfig:" + newConfig);
    }

    public void onButton4LocalUIClicked(View view) {
        Log.d("MainActivity", "onButton4LocalUIClicked");
        try {
            boolean ret = bindService(new Intent(this, LocalService.class), mLocalConnection, Context.BIND_AUTO_CREATE);
            Log.d("MainActivity", "bindService ret:" + ret);
        } catch (Exception e) {
            Log.d("MainActivity", "bindService Exception:" + e);
        }
    }

    public void onButton4LocalWorkerClicked(View view) {
        Log.d("MainActivity", "onButton4LocalWorkerClicked");
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != mLocalService) {
                    try {
                        Log.d("MainActivity", "local pid:" + Process.myPid() + "/tid:" + Process.myTid());
                        Log.d("MainActivity", "remote getPid:" + mLocalService.getPid());
                        Log.d("MainActivity", "remote getTid:" + mLocalService.getTid());
                        mLocalService.sendMessage("Called from client");
                    } catch (Exception e) {
                        Log.d("MainActivity", "Remote Exception:" + e);
                    }
                }
            }
        }).start();
    }

    public void onButton4RemoteUIClicked(View view) {
        Log.d("MainActivity", "onButton4RemoteUIClicked");
        try {
            boolean ret = bindService(new Intent(this, RemoteService.class), mRemoteConnection, Context.BIND_AUTO_CREATE);
            Log.d("MainActivity", "bindService ret:" + ret);
        } catch (Exception e) {
            Log.d("MainActivity", "bindService Exception:" + e);
        }
    }

    public void onButton4RemoteWorkerClicked(View view) {
        Log.d("MainActivity", "onButton4RemoteWorkerClicked");
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != mRemoteService) {
                    try {
                        mRemoteService.registerCallback(mRemoteServiceCallback);
                        User user = new User("BBB", 222);
                        mRemoteService.printUser(user);
                        mRemoteService.printUser2(user);
                        mRemoteService.printUser3(user);
                        Log.d("MainActivity", "User:" + user);
                    } catch (Exception e) {
                        Log.d("MainActivity", "Remote Exception:" + e);
                    }
                }
            }
        }).start();
    }
}
