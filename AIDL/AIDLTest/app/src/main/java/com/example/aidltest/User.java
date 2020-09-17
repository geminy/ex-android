// User.java
package com.example.aidltest;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String mName;
    private int mAge;

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
        this("default", 0);
    }

    public User(String name, int age) {
        mName = name;
        mAge = age;
    }

    public User(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        mName = in.readString();
        mAge = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName + "?");
        out.writeInt(mAge * 100);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "/mName:" + mName + "/mAge:" + mAge;
    }
}
