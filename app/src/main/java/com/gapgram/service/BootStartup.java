package com.gapgram.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootStartup extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"BootStartup.......BootStartup", Toast.LENGTH_LONG).show();
    }
}
