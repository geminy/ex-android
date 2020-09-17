/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /evo/AIDLTest/app/src/main/aidl/com/example/aidltest/IRemoteServiceCallback.aidl
 */
package com.example.aidltest;
// Declare any non-default types here with import statements

public interface IRemoteServiceCallback extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.example.aidltest.IRemoteServiceCallback
    {
        private static final java.lang.String DESCRIPTOR = "com.example.aidltest.IRemoteServiceCallback";
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an com.example.aidltest.IRemoteServiceCallback interface,
         * generating a proxy if needed.
         */
        public static com.example.aidltest.IRemoteServiceCallback asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.example.aidltest.IRemoteServiceCallback))) {
                return ((com.example.aidltest.IRemoteServiceCallback)iin);
            }
            return new com.example.aidltest.IRemoteServiceCallback.Stub.Proxy(obj);
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
                case TRANSACTION_hello:
                {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.hello(_arg0);
                    reply.writeNoException();
                    return true;
                }
                default:
                {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
        private static class Proxy implements com.example.aidltest.IRemoteServiceCallback
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
            public void hello(int flag) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(flag);
                    mRemote.transact(Stub.TRANSACTION_hello, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
        static final int TRANSACTION_hello = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }
    public void hello(int flag) throws android.os.RemoteException;
}
