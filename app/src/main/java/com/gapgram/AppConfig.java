package com.gapgram;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.gapgram.service.notification.MyNotificationOpenedHandler;
import com.gapgram.service.notification.MyNotificationReceivedHandler;
import com.onesignal.OneSignal;

import io.realm.Realm;

public class AppConfig extends MultiDexApplication {

    public static final String TAG = AppConfig.class
            .getSimpleName();

    private static AppConfig mInstance;
    private static AppConfig appInstance;

    // public AppConfiguration appInstance;

    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static AppConfig getAppInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        //MultiDex.install(this);
      /*  OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();*/
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new MyNotificationOpenedHandler())
                .setNotificationReceivedHandler( new MyNotificationReceivedHandler() )
                .init();

    }
}
