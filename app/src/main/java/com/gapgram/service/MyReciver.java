package com.gapgram.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("","");


        Intent intent_call=new Intent();
        intent_call.setClassName("com.android.gapgram2","com.android.gapgram2.MyReciver");
        intent_call.setAction("com.android.gapgram2.MyReciver");
        intent_call.putExtra("id","2");
        intent_call.putExtra("data","Hi");
        context.sendBroadcast(intent_call);


    }
}
