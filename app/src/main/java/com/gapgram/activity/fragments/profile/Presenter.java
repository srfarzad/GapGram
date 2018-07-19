package com.gapgram.activity.fragments.profile;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by setareh on 6/10/2018.
 */

public abstract class Presenter {

    protected View view;
    private AppCompatActivity activity;

    public Presenter(AppCompatActivity activity, View view){
        this.activity = activity;
        this.view = view;
        onCreateView();
    }

    public View getView(){
        return view;
    }

    public abstract void onCreateView();
}
