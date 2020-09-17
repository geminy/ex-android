package com.example.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private static final String TAG = "ViewTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. attribute inflate
//        setContentView(R.layout.activity_main);
//        TextView textView = findViewById(R.id.text_view);
//        String text = textView.getText().toString();
//        Log.d(TAG, "MainActivity onCreate xml text:" + text);
//        textView.setText("xxx");
//        text = textView.getText().toString();
//        Log.d(TAG, "MainActivity onCreate set text:" + text);

        // 2. focus
//        setContentView(R.layout.layout_focus);
//        MyEditText editText = findViewById(R.id.edit_text);
//        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            public void onFocusChange(View v, boolean hasFocus) {
//                Log.d(TAG, "MainActivity onFocusChange v:" + v + " hasFocus:" + hasFocus);
//            }
//        });

        // 3. visibility
//        setContentView(R.layout.layout_linear);
//        final Button button = findViewById(R.id.button_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.d(TAG, "MainActivity onClick v:" + v);
//                button.setVisibility(View.GONE);
//            }
//        });

        // 4. geometry
//        setContentView(R.layout.layout_geometry);

        // 5. scroll
        setContentView(R.layout.layout_scoll);
        ScrollLayout l = findViewById(R.id.scrollLayout);
        l.setOnScrollChangeListener(new View.OnScrollChangeListener(){
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "MainActivity onScrollChange ----------" + v);
                Log.d(TAG, "MainActivity onScrollChange:" + scrollX + " " + scrollY + " " + oldScrollX + " " + oldScrollY);
            }
        });
    }
}
