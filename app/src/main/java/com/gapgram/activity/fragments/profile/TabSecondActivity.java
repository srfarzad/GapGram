package com.gapgram.activity.fragments.profile;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gapgram.R;

import butterknife.BindView;

/**
 * Created by setareh on 6/12/2018.
 */

public class TabSecondActivity extends Presenter {

    @BindView(R.id.txt2)
    TextView txt2;

    public TabSecondActivity(AppCompatActivity activity, View view) {
        super(activity, view);
    }

    @Override
    public void onCreateView() {

    }
}
