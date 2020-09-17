package com.example.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends Activity{
    public final static String TAG = "DataBinding";
    private ActivityMainBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity onCreate");
        // inflate ?
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("Test", "User");
        binding.setUser(user);
        binding.setHandlers(new MyHandlers());
        binding.setPresenter(new Presenter());
    }

    public void changeUser(View view) {
        Log.d(TAG, "MainActivity changeUser " + user);
        user.setFirstName(user.getFirstName() + "1");
        user.setLastName(user.getLastName() + "2");
//        binding.setUser(user);
//        binding.setVariable(1, user);
        binding.invalidateAll();
    }

    public void printText(View view, String text) {
        Log.d(TAG, "MainActivity printText " + text);
    }
}
