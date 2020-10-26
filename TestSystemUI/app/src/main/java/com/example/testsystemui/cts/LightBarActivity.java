package com.example.testsystemui.cts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.testsystemui.R;

public class LightBarActivity extends Activity {
    private static LightBarActivity sInstance;

    private LinearLayout mContent;

    public static LightBarActivity getInstance() {
        return sInstance;
    }

    public View getContent() {
        return mContent;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mContent = new LinearLayout(this);
        mContent.setOrientation(LinearLayout.HORIZONTAL);
        mContent.setGravity(Gravity.LEFT);
        mContent.setBackgroundColor(Color.RED);
        for (int i = 0; i < 10; ++i) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(R.drawable.ic_save);
            mContent.addView(image, 100, 100);
        }
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                100);
        setContentView(mContent, lp);

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
