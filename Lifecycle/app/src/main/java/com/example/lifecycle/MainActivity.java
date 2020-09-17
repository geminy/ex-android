package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private MyViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "MainActivity onCreate");

        getLifecycle().addObserver(MyLifecycleObserver.getObserver());

        mTextView = (TextView) findViewById(R.id.textView);
        mModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mModel.getData().observe(this, new MyObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "MainActivity onDestroy");
        getLifecycle().removeObserver(MyLifecycleObserver.getObserver());
        mModel.getData().removeObservers(this);
    }

    public void onButtonClick(View view) {
        Log.d("Lifecycle", "MainActivity onButtonClick view:" + view);
        mModel.getData().setValue(mTextView.getText() + "1");
    }

    private class MyObserver implements Observer<String> {
        @Override
        public void onChanged(String data) {
            Log.d("Lifecycle", "MainActivity MyObserver onChanged data:" + data);
            mTextView.setText(data);
        }
    }
}
