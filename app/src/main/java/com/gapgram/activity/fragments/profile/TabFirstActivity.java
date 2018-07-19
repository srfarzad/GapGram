package com.gapgram.activity.fragments.profile;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gapgram.R;

import butterknife.BindView;

/**
 * Created by setareh on 6/12/2018.
 */

public class TabFirstActivity extends Presenter {

    @BindView(R.id.txt1)
    TextView txt1;

    public TabFirstActivity(AppCompatActivity activity, View view) {
        super(activity, view);
    }

    @Override
    public void onCreateView() {

    }
}
