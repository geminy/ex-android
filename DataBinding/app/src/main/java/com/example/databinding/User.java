package com.example.databinding;

import android.util.Log;

import static com.example.databinding.MainActivity.TAG;

// 1. field
//public class User {
//    public final String firstName;
//    public final String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//}

// 2. method
//public class User {
//    private final String firstName;
//    private final String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String firstName() {
//        return this.firstName;
//    }
//    public String lastName() {
//        return this.lastName;
//    }
//}

// 3.getter
//public class User {
//    private final String firstName;
//    private final String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//    public String getLastName() {
//        return this.lastName;
//    }
//}

// 3.getter/setter
public class User {
    private String mFirstName;
    private String mLastName;

    public User(String firstName, String lastName) {
        Log.d(TAG, "User");
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public String getFirstName() {
        Log.d(TAG, "User getFirstName");
        return this.mFirstName;
    }

    public void setFirstName(String firstName) {
        Log.d(TAG, "User setFirstName");
        this.mFirstName = firstName;
    }

    public String getLastName() {
        Log.d(TAG, "User getLastName");
        return this.mLastName;
    }

    public void setLastName(String lastName) {
        Log.d(TAG, "User setLastName");
        this.mLastName = lastName;
    }

    @Override
    public String toString() {
        Log.d(TAG, "User toString");
        return "User:" + mFirstName + "/" + mLastName;
    }
}
