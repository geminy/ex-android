package com.example.testsystemui.cts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class LightBarActivity extends Activity {
    private static LightBarActivity sInstance;

    private View mContent;

    public static LightBarActivity getInstance() {
        return sInstance;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mContent = new View(this);
        mContent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        setContentView(mContent);

        sInstance = this;
        mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LightBarTests.getInstance().testLightStatusBarIcons();
            }
        });
    }

    public int getSystemUiVisibility() {
        return mContent.getSystemUiVisibility();
    }

    public int getTop() {
        int[] location = new int[2];
        mContent.getLocationOnScreen(location);
        return location[1];
    }

    public int getBottom() {
        int[] location = new int[2];
        mContent.getLocationOnScreen(location);
        return location[1] + mContent.getHeight();
    }

    public int getWidth() {
        return mContent.getWidth();
    }

    public void setLightStatusBar(boolean lightStatusBar) {
        setLightBar(lightStatusBar, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void setLightNavigationBar(boolean lightNavigationBar) {
        setLightBar(lightNavigationBar, View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
    }

    private void setLightBar(boolean light, int systemUiFlag) {
        int vis = getWindow().getDecorView().getSystemUiVisibility();
        if (light) {
            vis |= systemUiFlag;
        } else {
            vis &= ~systemUiFlag;
        }
        getWindow().getDecorView().setSystemUiVisibility(vis);
    }
}