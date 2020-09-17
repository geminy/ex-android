package com.example.databinding;

import android.util.Log;
import android.view.View;

import static com.example.databinding.MainActivity.TAG;

public class Presenter {
    public Presenter() {
        Log.d(TAG, "Presenter");
    }

    public void onSaveClick(User user) {
        Log.d(TAG, "Presenter onSaveClick user " + user);
    }

    public void onSaveClick(String name) {
        Log.d(TAG, "Presenter onSaveClick name " + name);
    }

    public void onSaveClick(View view, User user) {
        Log.d(TAG, "Presenter onSaveClick view " + view + " user " + user);
    }
}
