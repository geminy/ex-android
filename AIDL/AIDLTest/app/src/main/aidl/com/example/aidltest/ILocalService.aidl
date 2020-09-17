// ILocalService.aidl
package com.example.aidltest;

// Declare any non-default types here with import statements

interface ILocalService {
    int getPid();
    int getTid();
    void sendMessage(String message);
}
