package com.example.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {
    private static final String TAG_CLASS_NAME = "MainActivity";

    private ViewGroup mViewRoot;

    private View mViewRed;
    private View mViewGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLog.output(TAG_CLASS_NAME, "onCreate", "");
        setContentView(R.layout.activity_main);
        mViewRoot = findViewById(R.id.activity_main_root);
        mViewRed = getLayoutInflater().inflate(R.layout.layout_view_red, mViewRoot, false);
        mViewGreen = getLayoutInflater().inflate(R.layout.layout_view_green, mViewRoot, false);
        mViewRed.setAlpha(0.5f);
        mViewGreen.setAlpha(0.5f);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLog.output(TAG_CLASS_NAME, "onStart", "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLog.output(TAG_CLASS_NAME, "onPause", "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLog.output(TAG_CLASS_NAME, "onStop", "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.output(TAG_CLASS_NAME, "onDestroy", "");
    }

    public void onClick(View view) {
        MyLog.output(TAG_CLASS_NAME, "onClick", "");
        openViewRed();
    }

    public void onClickRedView(View view) {
        MyLog.output(TAG_CLASS_NAME, "onClickRedView", "");
        closeViewRed();
        openViewGreen();
    }

    private void openViewRed() {
        MyLog.output(TAG_CLASS_NAME, "openRedView", "");
        mViewRoot.addView(mViewRed);
        playAnimationOpenRed();
    }

    private void playAnimationOpenRed() {
        Animator animator = ObjectAnimator.ofFloat(mViewRed, "x", -1000, 0);
        animator.setDuration(2000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationStart", "open red");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationEnd", "open red");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationCancel", "open red");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationRepeat", "open red");
            }
        });
        animator.start();
    }

    private void closeViewRed() {
        MyLog.output(TAG_CLASS_NAME, "closeViewRed", "");
        playAnimationCloseRed();
    }

    private void playAnimationCloseRed() {
        MyLog.output(TAG_CLASS_NAME, "playAnimationCloseRed", "");
        Animator animator = ObjectAnimator.ofFloat(mViewRed, "x", 0, 1000);
        animator.setDuration(2000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationStart", "close red");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationEnd", "close red");
                mViewRoot.removeView(mViewRed);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationCancel", "close red");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationRepeat", "close red");
            }
        });
        animator.start();
    }

    private void openViewGreen() {
        MyLog.output(TAG_CLASS_NAME, "openViewGreen", "");
        mViewRoot.addView(mViewGreen);
        playAnimationOpenGreen();
    }

    private void playAnimationOpenGreen() {
        Animator animator = ObjectAnimator.ofFloat(mViewGreen, "x", -1000, 0);
        animator.setDuration(2000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationStart", "open green");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationEnd", "open green");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationCancel", "open green");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                MyLog.output(TAG_CLASS_NAME, "onAnimationRepeat", "open green");
            }
        });
        animator.start();
    }
}