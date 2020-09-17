package com.example.lifecycle;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> mData;

    public MyViewModel() {
        Log.d("Lifecycle", "MyViewModel");
    }

    public MutableLiveData<String> getData() {
        if (mData == null) {
            mData = new MutableLiveData<>();
            mData.setValue("Default");
        }
        Log.d("Lifecycle", "getData data:" + mData);
        return mData;
    }

    @Override
    protected void onCleared() {
        Log.d("Lifecycle", "onCleared");
    }
}
