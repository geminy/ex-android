package com.example.testsystemui.cts;

import android.app.ActivityManager;
import android.app.Instrumentation;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.UiAutomation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

import com.example.testsystemui.MyLog;
import com.example.testsystemui.R;

public class LightBarTests {
    private static LightBarTests sInstance;

    private static final String NOTIFICATION_TAG = "TEST_TAG";
    private static final String NOTIFICATION_CHANNEL_ID = "test_channel";
    private static final String NOTIFICATION_GROUP_KEY = "test_channel";

    private static final int WAIT_TIME = 2000;

    private static final int COLOR_COMPONENT_ERROR_MARGIN = 10;

    private NotificationManager mNm;

    public static LightBarTests getInstance() {
        if (sInstance == null) {
            sInstance = new LightBarTests();
        }
        return sInstance;
    }

    private LightBarTests() {}

    public void testLightStatusBarIcons() {
        assumeHasColoredStatusBar();

        mNm = (NotificationManager) LightBarActivity.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel1 = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        mNm.createNotificationChannel(channel1);

        for (int i = 0; i < 10; ++i) {
            Notification.Builder noti1 = new Notification.Builder(LightBarActivity.getInstance(),
                    NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_save)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setGroup(NOTIFICATION_GROUP_KEY);
            mNm.notify(NOTIFICATION_TAG, i, noti1.build());
        }

        requestLightBar(Color.RED);
        try {
            Thread.sleep(WAIT_TIME);
        } catch (Exception e) {

        }

        Bitmap bitmap = takeStatusBarScreenshot();
        Stats s = evaluateLightBarBitmap(bitmap, Color.RED);
        assertLightStats(bitmap, s);

        mNm.cancelAll();
        mNm.deleteNotificationChannel(NOTIFICATION_CHANNEL_ID);
    }

    private void requestLightBar(int background) {
        LightBarActivity activity = LightBarActivity.getInstance();
        activity.getWindow().setStatusBarColor(background);
        activity.getWindow().setNavigationBarColor(background);
        activity.setLightStatusBar(true);
        activity.setLightNavigationBar(true);
    }

    private void assumeHasColoredStatusBar() {
        assumeBasic();
        isRunningInVr();
    }

    private void assumeBasic() {
        PackageManager pm = LightBarActivity.getInstance().getPackageManager();
        boolean embeded = pm.hasSystemFeature(PackageManager.FEATURE_EMBEDDED);
        MyLog.output("LightBarTests", "assumeBasic", "embeded false:" + embeded);
        boolean watch = pm.hasSystemFeature(PackageManager.FEATURE_WATCH);
        MyLog.output("LightBarTests", "assumeBasic", "watch false:" + watch);
        boolean television = pm.hasSystemFeature(PackageManager.FEATURE_TELEVISION);
        MyLog.output("LightBarTests", "assumeBasic", "television false:" + television);
        boolean leanback = pm.hasSystemFeature(PackageManager.FEATURE_LEANBACK);
        MyLog.output("LightBarTests", "assumeBasic", "leanback false:" + leanback);
//        boolean gfx = ActivityManager.isHighEndGfx();
//        MyLog.output("LightBarTests", "assumeBasic", "gfx true:" + gfx);
    }

    private void isRunningInVr() {
        Configuration config = LightBarActivity.getInstance().getResources().getConfiguration();
        boolean vr = ((config.uiMode & Configuration.UI_MODE_TYPE_MASK) == Configuration.UI_MODE_TYPE_VR_HEADSET);
        MyLog.output("LightBarTests", "isRunningInVr", "vr false:" + vr);
    }

    private Bitmap takeStatusBarScreenshot() {
//        Instrumentation instrumentation = new Instrumentation();
//        UiAutomation uiAutomation = instrumentation.getUiAutomation();
//        Bitmap fullBitmap = uiAutomation.takeScreenshot();
//        int x = 0;
//        int y = 0;
//        int width = LightBarActivity.getInstance().getWidth();
//        int height = LightBarActivity.getInstance().getTop();
//        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "x:" + x);
//        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "y:" + y);
//        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "width:" + width);
//        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "height:" + height);
//        return Bitmap.createBitmap(fullBitmap, 0, 0, width, height);
        View view = LightBarActivity.getInstance().getContent();
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "view width:" + view.getWidth());
        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "view height:" + view.getHeight());
        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "bitmap width:" + bitmap.getWidth());
        MyLog.output("LightBarTests", "takeStatusBarScreenshot", "bitmap height:" + bitmap.getHeight());
        return bitmap;
    }

    private static class Stats {
        int backgroundPixels;
        int iconPixels;
        int sameHueDarkPixels;
        int sameHueLightPixels;
        int unexpectedHuePixes;

        int totalPixels() {
            return backgroundPixels + iconPixels + sameHueDarkPixels + sameHueLightPixels + unexpectedHuePixes;
        }

        int foregroundPixels() {
            return iconPixels + sameHueDarkPixels + sameHueLightPixels + unexpectedHuePixes;
        }

        @Override
        public String toString() {
            return String.format("{bg=%d, ic=%d, dark=%d, light=%d, bad=%d}",
                    backgroundPixels, iconPixels, sameHueDarkPixels, sameHueLightPixels, unexpectedHuePixes);
        }
    }

    private Stats evaluateLightBarBitmap(Bitmap bitmap, int background) {
        MyLog.output("LightBarTests", "evaluateLightBarBitmap", "background:" + background);

        int iconColor = 0x99000000;
        int iconPartialColor = 0x3d000000;
        MyLog.output("LightBarTests", "evaluateLightBarBitmap", "iconColor:" + iconColor);
        MyLog.output("LightBarTests", "evaluateLightBarBitmap", "iconPartialColor:" + iconPartialColor);


        int mixedIconColor = mixSrcOver(background, iconColor);
        int mixedIconPartialColor = mixSrcOver(background, iconPartialColor);
        MyLog.output("LightBarTests", "evaluateLightBarBitmap", "mixedIconColor:" + mixedIconColor);
        MyLog.output("LightBarTests", "evaluateLightBarBitmap", "mixedIconPartialColor:" + mixedIconPartialColor);

        int[] pixels = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        Stats s = new Stats();
        float eps = 0.005f;

        for (int c : pixels) {
            if (c == background) {
                s.backgroundPixels++;
                continue;
            }

            if (isColorSame(c, mixedIconColor) || isColorSame(c, mixedIconPartialColor)) {
                s.iconPixels++;
                continue;
            }

            float hueDiff = Math.abs(ColorUtils.hue(background) - ColorUtils.hue(c));
            if (hueDiff < eps || hueDiff > 1 - eps) {
                if (ColorUtils.brightness(c) > ColorUtils.brightness(background)) {
                    s.sameHueLightPixels++;
                } else {
                    s.sameHueDarkPixels++;
                }
                continue;
            }

            s.unexpectedHuePixes++;
        }

        return s;
    }

    public static int mixSrcOver(int background, int foreground) {
        int bgAlpha = Color.alpha(background);
        int bgRed = Color.red(background);
        int bgGreen = Color.green(background);
        int bgBlue = Color.blue(background);

        int fgAlpha = Color.alpha(foreground);
        int fgRed = Color.red(foreground);
        int fgGreen = Color.green(foreground);
        int fgBlue = Color.blue(foreground);

        return Color.argb(fgAlpha + (255 - fgAlpha) * bgAlpha / 255,
                fgRed + (255 - fgRed) * bgRed / 255,
                fgGreen + (255 - fgGreen) * bgGreen / 255,
                fgBlue + (255 - fgBlue) * bgBlue / 255);
    }

    private boolean isColorSame(int c1, int c2) {
        return Math.abs(Color.alpha(c1) - Color.alpha(c2)) < COLOR_COMPONENT_ERROR_MARGIN
                && Math.abs(Color.red(c1) - Color.red(c2)) < COLOR_COMPONENT_ERROR_MARGIN
                && Math.abs(Color.green(c1) - Color.green(c2)) < COLOR_COMPONENT_ERROR_MARGIN
                && Math.abs(Color.blue(c1) - Color.blue(c2)) < COLOR_COMPONENT_ERROR_MARGIN;
    }

    private void assertLightStats(Bitmap bitmap, Stats s) {
        MyLog.output("LightBarTests", "assertLightStats", "Stats:" + s);

        float bgPixels = 0.3f;
        float bgPixelsReal = (float) s.backgroundPixels / s.totalPixels();
        MyLog.output("LightBarTests", "assertLightStats", "bgPixels 0.3f < " + bgPixelsReal);

        float iconPixels = 0.3f;
        float iconPixelsReal = (float) s.iconPixels / s.foregroundPixels();
        MyLog.output("LightBarTests", "assertLightStats", "iconPixels 0.3f < " + iconPixelsReal);

        float lightPixels = 0.05f;
        float lightPixelsReal = (float) s.sameHueLightPixels / s.foregroundPixels();
        MyLog.output("LightBarTests", "assertLightStats", "lightPixels 0.05f > " + lightPixels);

        float unexpectedPixels = 0.05f;
        float unexpectedPixelsReal = (float) s.unexpectedHuePixes / s.foregroundPixels();
        MyLog.output("LightBarTests", "assertLightStats", "unexpectedPixels 0.05f > " + unexpectedPixelsReal);
    }
}
