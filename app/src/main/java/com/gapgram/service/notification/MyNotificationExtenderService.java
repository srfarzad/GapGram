package com.gapgram.service.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.gapgram.AppConfig;
import com.gapgram.R;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

import java.math.BigInteger;

/**
 * Created by Android on 5/2/2017.
 */

public class MyNotificationExtenderService extends NotificationExtenderService {


    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
        OverrideSettings overrideSettings = new OverrideSettings();
        overrideSettings.extender = new NotificationCompat.Extender() {
            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
                // Sets the background notification color to Red on Android 5.0+ devices.
                Bitmap icon = BitmapFactory.decodeResource(AppConfig.getContext().getResources(),
                        R.mipmap.ic_launcher);
                builder.setLargeIcon(icon);
                return builder.setColor(new BigInteger("FF0000FF", 16).intValue());
            }
        };

        OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);

        return true;
    }
/*
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
       // OverrideSettings overrideSettings = new OverrideSettings();
       overrideSettings.extender = new NotificationCompat.Extender() {
            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
                // Sets the background notification color to Red on Android 5.0+ devices.
                Bitmap icon = BitmapFactory.decodeResource(AppConfiguration.getContext().getResources(),
                        R.mipmap.ic_launcher);
                builder.setLargeIcon(icon);
                return builder.setColor(new BigInteger("FF0000FF", 16).intValue());
            }
        };*/

       /* overrideSettings.extender =new NotificationCompat.Extender(){

            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {



                return null;
            }
         };*/


        //OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        //Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);

/*
        NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(AppConfiguration.getContext())
                .setSmallIcon(R.drawable.ic_launcher) // notification icon
                .setContentTitle("Notification!") // title for notification
                .setContentText("Hello word") // message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(AppConfiguration.getContext(), DashboardActivity.class);
        intent.putExtra("id",1);
        PendingIntent pi = PendingIntent.getActivity(AppConfiguration.getContext(),0,
                intent,PendingIntent.FLAG_ONE_SHOT);
        mBuilder.setContentIntent(pi);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int id=(int)System.currentTimeMillis();
        mNotificationManager.notify(id, mBuilder.build());


        return true;
    }*/
}
