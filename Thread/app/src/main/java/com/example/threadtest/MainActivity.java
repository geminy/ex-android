package com.example.threadtest;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ThreadTest", "MainActivity onCreate");

        new Thread() {
            @Override
            public void run() {
                Log.d("ThreadTest", "Thread run");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("ThreadTest", "Runnable run");

            }
        }).start();

        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Log.d("ThreadTest", "Callable call");
                return null;
            }
        }) {
        }).start();

        new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                Log.d("ThreadTest", "AsyncTask onPreExecute");
            }

            @Override
            protected Integer doInBackground(Integer... params) {
                Log.d("ThreadTest", "AsyncTask doInBackground " + params);
                publishProgress(50);
                publishProgress(100);
                return 100;
            }

            @Override
            protected void onProgressUpdate(Integer... progress) {
                Log.d("ThreadTest", "AsyncTask onProgressUpdate " + progress);
            }

            @Override
            protected void onPostExecute(Integer result) {
                Log.d("ThreadTest", "AsyncTask onPostExecute " + result);
            }
        }.execute(new Integer(1), new Integer(2));

        new Thread() {
            @Override
            public void run() {
                Log.d("ThreadTest", "Thread run to send message");
                myHandler.sendEmptyMessage(100);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Log.d("ThreadTest", "run on worker thread");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("ThreadTest", "run on ui thread");
                    }
                });
            }
        }.start();
    }

    private MyHandler myHandler = new MyHandler();

    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d("ThreadTest", "Handler handleMessage " + msg);
        }
    }
}
