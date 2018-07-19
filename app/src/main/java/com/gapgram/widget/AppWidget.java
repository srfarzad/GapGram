package com.gapgram.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.RemoteViews;

import com.gapgram.R;

public class AppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);


        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetIds){

        RemoteViews views=new RemoteViews(context.getPackageName(), R.layout.app_widget_layout);
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.btn_click,pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds,views);

    }
}
