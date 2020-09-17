package com.example.databinding2;

import android.util.Log;
import android.view.View;

public class User {
    private String mFirstName;
    private String mLastName;

    public User() {
        this("Hello", "Android");
    }

    public User(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
        Log.d("DataBinding2", "User firstName:" + firstName + " lastName:" + lastName);
    }

    public void setFirstName(String name) {
        mFirstName = name;
        Log.d("DataBinding2", "User setFirstName name:" + name);
    }

    public String getFirstName() {
        Log.d("DataBinding2", "User getFirstName name:" + mFirstName);
        return mFirstName;
    }

    public void setLastName(String name) {
        mLastName = name;
        Log.d("DataBinding2", "User setLastName name:" + name);
    }

    public String getLastName() {
        Log.d("DataBinding2", "User getLastName name:" + mLastName);
        return mLastName;
    }

    public void onClickUser(View view) {
        Log.d("DataBinding2", "User onClickUser view:" + view);
    }

    public void onSaveUser(User user) {
        Log.d("DataBinding2", "User onSaveUser firstName:" + user.mFirstName + " lastName:" + user.mLastName);
    }

    public static String capitalize(String str) {
        Log.d("DataBinding2", "User capitalize str:" + str);
        return str.toUpperCase();
    }
}
