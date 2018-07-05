package com.gapgram.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.gapgram.model.LauncherService;

public class GameServiceCenter {

    public void init(Context context, String packageName, final LauncherService launcherService){


        Intent intent=new Intent("com.gapgram");
        intent.setPackage(packageName);

        ServiceConnection serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                launcherService.onResult(com.gapgram.GameService.Stub.asInterface(iBinder));
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                launcherService.onFail("fail");
            }
        };

        context.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);


    }

}
