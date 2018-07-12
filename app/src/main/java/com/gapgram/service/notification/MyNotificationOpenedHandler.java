package com.gapgram.service.notification;

import android.content.Intent;
import android.util.Log;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Android on 5/2/2017.
 */

public class MyNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {


    // This fires when a notification is opened by tapping on it.
    @Override
    public void notificationOpened(OSNotificationOpenResult result) {
        OSNotificationAction.ActionType actionType = result.action.type;
        JSONObject data = result.notification.payload.additionalData;
        String activityToBeOpened;
        String type="",contentText="";
       /* try {
           // type=data.getString("type");
          //  contentText=data.getString("contentText");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        if (data != null) {
            activityToBeOpened = data.optString("activityToBeOpened", null);
            if (type.equals("ADS")) {
                Log.i("OneSignalExample", "customkey set with value: " + activityToBeOpened);
               // Intent intent = new Intent(AppConfiguration.getContext(), DashboardActivity.class);
             //   intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
              //  intent.putExtra("id",2);
              //  intent.putExtra("contentText",contentText);
               // AppConfiguration.getContext().startActivity(intent);
            } else if (type.equals("dailyAyet")) {
                Log.i("OneSignalExample", "customkey set with value: " + activityToBeOpened);
              //  Intent intent = new Intent(AppConfiguration.getContext(), DashboardActivity.class);
              //  intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
              //  intent.putExtra("id",1);
             //   intent.putExtra("contentText",contentText);
              //  AppConfiguration.getContext().startActivity(intent);
            }
            else if (type.equals("help")) {
                Log.i("OneSignalExample", "customkey set with value: " + activityToBeOpened);
              //  Intent intent = new Intent(AppConfiguration.getContext(), DashboardActivity.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
               // intent.putExtra("id",3);
               // intent.putExtra("contentText",contentText);
               // AppConfiguration.getContext().startActivity(intent);
            }
            else {

              //  Intent intent = new Intent(AppConfiguration.getContext(), DashboardActivity.class);
              //  intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
              //  AppConfiguration.getContext().startActivity(intent);
            }


        }



    }

}
