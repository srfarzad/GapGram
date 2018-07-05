package com.gapgram.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gapgram.RequestCallback;

public class GameService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mbinder;
    }


    public final com.gapgram.GameService.Stub mbinder=new com.gapgram.GameService.Stub() {
        @Override
        public void newMatch(String params) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void canAcceptMatch(String params, RequestCallback callback) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void startApp(String params) throws RemoteException {
            Log.e("","");
        }
    };





}
