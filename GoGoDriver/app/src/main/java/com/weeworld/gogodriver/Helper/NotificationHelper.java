package com.weeworld.gogodriver.Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import com.weeworld.gogodriver.R;
import androidx.annotation.RequiresApi;

public class NotificationHelper extends ContextWrapper {
    private static final String CHANEL_ID = "gogodriver.Android";
    private static final String CHANEL_NAME = "GoGoDriver";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)//only working when Api >=26
            createChannel();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel gogodriver = new NotificationChannel(CHANEL_ID,
                CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        gogodriver.enableLights(false);
        gogodriver.enableVibration(true);
        gogodriver.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(gogodriver);

    }

    public NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getNotificationChannel(String title, String body, PendingIntent contenIntent
            , Uri soundUri) {
        return new Notification.Builder(getApplicationContext(),
                CHANEL_ID).setContentIntent(contenIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_baseline_local_shipping_24)
                .setAutoCancel(false);
    }
}
