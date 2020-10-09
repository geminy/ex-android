package com.example.testsystemui.cts;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;

import com.example.testsystemui.R;

public class LightBarTests {
    private static LightBarTests sInstance;

    private static final int WAIT_TIME = 2000;

    private final String NOTIFICATION_TAG = "TEST_TAG";
    private final String NOTIFICATION_CHANNEL_ID = "test_channel";
    private final String NOTIFICATION_GROUP_KEY = "test_channel";

    private NotificationManager mNm;

    public static LightBarTests getInstance() {
        if (sInstance == null) {
            sInstance = new LightBarTests();
        }
        return sInstance;
    }

    private LightBarTests() {}

    public void testLightStatusBarIcons() {
        mNm = (NotificationManager) LightBarActivity.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel1 = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        mNm.createNotificationChannel(channel1);

        for (int i = 0; i < 10; ++i) {
            Notification.Builder noti1 = new Notification.Builder(LightBarActivity.getInstance(),
                    NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_save)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setPriority(Notification.PRIORITY_LOW)
                    .setGroup(NOTIFICATION_GROUP_KEY);
            mNm.notify(NOTIFICATION_TAG, i, noti1.build());
        }

        requestLightBar(Color.RED);
//        try {
//            Thread.sleep(WAIT_TIME);
//        } catch (Exception e) {
//
//        }
//
//        mNm.cancelAll();
//        mNm.deleteNotificationChannel(NOTIFICATION_CHANNEL_ID);
    }

    private void requestLightBar(int background) {
        LightBarActivity activity = LightBarActivity.getInstance();
        activity.getWindow().setStatusBarColor(background);
        activity.getWindow().setNavigationBarColor(background);
        activity.setLightStatusBar(true);
        activity.setLightNavigationBar(true);
    }
}
