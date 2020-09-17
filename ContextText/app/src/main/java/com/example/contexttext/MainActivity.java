package com.example.contexttext;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ContextText", "MainActivity this:" + this);
        Log.d("ContextText", "MainActivity getBaseContext:" + getBaseContext());
        Log.d("ContextText", "MainActivity getApplicationContext:" + getApplicationContext());

        ConstraintLayout root = (ConstraintLayout) findViewById(R.id.layout_root);
        Log.d("ContextText", "MainActivity root this:" + root);
        Log.d("ContextText", "MainActivity root parent:" + root.getParent());
        Log.d("ContextText", "MainActivity root getContext:" + root.getContext());

        TextView view = (TextView) findViewById(R.id.text_view);
        Log.d("ContextText", "MainActivity TextView this:" + view);
        Log.d("ContextText", "MainActivity TextView parent:" + view.getParent());
        Log.d("ContextText", "MainActivity TextView getContext:" + view.getContext());

        MyView myView = (MyView) findViewById(R.id.my_view);
        Log.d("ContextText", "MainActivity MyView this:" + myView);
        Log.d("ContextText", "MainActivity MyView parent:" + myView.getParent());
        Log.d("ContextText", "MainActivity MyView getContext:" + myView.getContext());
    }
}
