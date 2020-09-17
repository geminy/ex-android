package com.example.databinding;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.example.databinding.MainActivity.TAG;

public class MyTextView extends TextView {
    private String mMyText;
    private OnMyClickListener mOnMyClickListener;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyTextView");
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        if (null != array) {
            String text = array.getString(R.styleable.MyTextView_myText);
            setMyText(text);
            String handlerName = array.getString(R.styleable.MyTextView_onMyClick);
            setOnMyClickListener(new DeclaredOnMyClickListener(this, handlerName));
            array.recycle();
        }
    }

    public String getMyText() {
        Log.d(TAG, "MyTextView getMyText");
        return mMyText;
    }

    public void setMyText(String text) {
        Log.d(TAG, "MyTextView setMyText");
        mMyText = text;
        setText(mMyText);
        if (mOnMyClickListener != null) {
            mOnMyClickListener.onMyClick(this, mMyText);
        }
    }

    public interface OnMyClickListener {
        void onMyClick(View view, String text);
    }

    public void setOnMyClickListener(OnMyClickListener l) {
        mOnMyClickListener = l;
    }

    private static class DeclaredOnMyClickListener implements OnMyClickListener {
        private final View mHostView;
        private final String mMethodName;

        private Method mResolvedMethod;
        private Context mResolvedContext;

        public DeclaredOnMyClickListener(View hostView, String methodName) {
            mHostView = hostView;
            mMethodName = methodName;
        }

        @Override
        public void onMyClick(View view, String text) {
            if (mResolvedMethod == null) {
                resolveMethod(mHostView.getContext(), mMethodName);
            }

            try {
                mResolvedMethod.invoke(mResolvedContext, view, text);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(
                        "@@Could not execute non-public method for app:onMyClick", e);
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(
                        "@@Could not execute method for app:onMyClick", e);
            }
        }

        private void resolveMethod(Context context, String name) {
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        final Method method = context.getClass().getMethod(mMethodName, View.class, String.class);
                        if (method != null) {
                            mResolvedMethod = method;
                            mResolvedContext = context;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                    // Failed to find method, keep searching up the hierarchy.
                }

                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    // Can't search up the hierarchy, null out and fail.
                    context = null;
                }
            }

            final int id = mHostView.getId();
            final String idText = id == NO_ID ? "" : " with id '"
                    + mHostView.getContext().getResources().getResourceEntryName(id) + "'";
            throw new IllegalStateException("Could not find method " + mMethodName
                    + "(View) in a parent or ancestor Context for android:onClick "
                    + "attribute defined on view " + mHostView.getClass() + idText);
        }
    }
}
