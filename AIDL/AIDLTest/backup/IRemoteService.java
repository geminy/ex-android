/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /evo/AIDLTest/app/src/main/aidl/com/example/aidltest/IRemoteService.aidl
 */
package com.example.aidltest;
public interface IRemoteService extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.example.aidltest.IRemoteService
    {
        private static final java.lang.String DESCRIPTOR = "com.example.aidltest.IRemoteService";
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an com.example.aidltest.IRemoteService interface,
         * generating a proxy if needed.
         */
        public static com.example.aidltest.IRemoteService asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.example.aidltest.IRemoteService))) {
                return ((com.example.aidltest.IRemoteService)iin);
            }
            return new com.example.aidltest.IRemoteService.Stub.Proxy(obj);
        }
        @Override
        public android.os.IBinder asBinder()
        {
            return this;
        }
        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
        {
            java.lang.String descriptor = DESCRIPTOR;
            switch (code)
            {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_add:
                {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = this.add(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_print:
                {
                    data.enforceInterface(descriptor);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.print(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_printUser:
                {
                    data.enforceInterface(descriptor);
                    com.example.aidltest.User _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.example.aidltest.User.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    this.printUser(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_printUser2:
                {
                    data.enforceInterface(descriptor);
                    com.example.aidltest.User _arg0;
                    _arg0 = new com.example.aidltest.User();
                    this.printUser2(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_printUser3:
                {
                    data.enforceInterface(descriptor);
                    com.example.aidltest.User _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.example.aidltest.User.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    this.printUser3(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_registerCallback:
                {
                    data.enforceInterface(descriptor);
                    com.example.aidltest.IRemoteServiceCallback _arg0;
                    _arg0 = com.example.aidltest.IRemoteServiceCallback.Stub.asInterface(data.readStrongBinder());
                    this.registerCallback(_arg0);
                    reply.writeNoException();
                    return true;
                }
                default:
                {
                    return super.onTransact(code, data, reply, flags);
                }
        }
    }
        private static class Proxy implements com.example.aidltest.IRemoteService
        {
            private android.os.IBinder mRemote;
            Proxy(android.os.IBinder remote)
            {
             mRemote = remote;
            }
            @Override
            public android.os.IBinder asBinder()
            {
                return mRemote;
            }
            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }
            @Override
            public int add(int a, int b) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(a);
                    _data.writeInt(b);
                    mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override
            public void print(java.lang.String string) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(string);
                    mRemote.transact(Stub.TRANSACTION_print, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override
            public void printUser(com.example.aidltest.User user) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((user != null)) {
                        _data.writeInt(1);
                        user.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_printUser, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override public void printUser2(com.example.aidltest.User user) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_printUser2, _data, _reply, 0);
                    _reply.readException();
                    if ((0!=_reply.readInt())) {
                        user.readFromParcel(_reply);
                    }
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override
            public void printUser3(com.example.aidltest.User user) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((user != null)) {
                        _data.writeInt(1);
                        user.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_printUser3, _data, _reply, 0);
                    _reply.readException();
                    if ((0 !=_reply.readInt())) {
                        user.readFromParcel(_reply);
                    }
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override public void registerCallback(com.example.aidltest.IRemoteServiceCallback callback) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((callback != null)) ? (callback.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
        static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_print = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_printUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_printUser2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_printUser3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    }
    public int add(int a, int b) throws android.os.RemoteException;
    public void print(java.lang.String string) throws android.os.RemoteException;
    public void printUser(com.example.aidltest.User user) throws android.os.RemoteException;
    public void printUser2(com.example.aidltest.User user) throws android.os.RemoteException;
    public void printUser3(com.example.aidltest.User user) throws android.os.RemoteException;
    public void registerCallback(com.example.aidltest.IRemoteServiceCallback callback) throws android.os.RemoteException;
}
