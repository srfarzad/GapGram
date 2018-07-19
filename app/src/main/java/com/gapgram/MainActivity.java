package com.gapgram;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import com.gapgram.adapter.HorizontalAdapter;
import com.gapgram.dagger.DaggerUserComponent;
import com.gapgram.dagger.UserComponent;
import com.gapgram.dagger.UserModule;
import com.gapgram.model.LauncherService;
import com.gapgram.model.StoryItem;
import com.gapgram.service.GameServiceCenter;
import com.gapgram.serviceCaller.WebserviceCaller;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class MainActivity extends Activity {

    HorizontalAdapter horizontalAdapter;
    private List<StoryItem> data;

    ImageView imgprofile;

    WebserviceCaller webserviceCaller;

    FirebaseAuth auth;

    FirebaseAnalytics analytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webserviceCaller=new WebserviceCaller();
        auth = FirebaseAuth.getInstance();
        analytics=FirebaseAnalytics.getInstance(this);


        Dexter.withActivity(MainActivity.this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Log.e("","");
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Log.e("","");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.e("","");
                    }
                }).check();


        GameServiceCenter gameServiceCenter=new GameServiceCenter();

        gameServiceCenter.init(getApplicationContext(), "com.android.gapgram2", new LauncherService() {
            @Override
            public void onResult(GameService gameInterface) {
                Log.e("","");
            }

            @Override
            public void onFail(String ErrorMessage) {
                Log.e("","");
            }
        });


        UserComponent component= DaggerUserComponent.builder().
                userModule(new UserModule()).build();

        component.provideUser().deleteUserMail();

        auth.createUserWithEmailAndPassword("sr.farzad@gmail.com","123@mnbE#")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });



        Bundle bundle=new Bundle();
        bundle.putString("user","1");
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN,bundle);


        AppConfig application = (AppConfig) getApplication();
        Tracker mTracker = application.getDefaultTracker();
       // Log.i(TAG, "Setting screen name: " + name);
        mTracker.setScreenName("main Activity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }
}

