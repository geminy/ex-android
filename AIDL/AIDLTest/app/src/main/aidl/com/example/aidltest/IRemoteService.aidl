// IRemoteService.aidl
package com.example.aidltest;

import com.example.aidltest.IRemoteServiceCallback;
import com.example.aidltest.User;

interface IRemoteService {
    int add(int a, int b);
    void print(String string);

    void printUser(in User user);
    void printUser2(out User user);
    void printUser3(inout User user);

    void registerCallback(IRemoteServiceCallback callback);
}
