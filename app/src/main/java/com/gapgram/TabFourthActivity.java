package com.gapgram;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by setareh on 6/12/2018.
 */

public class TabFourthActivity extends Presenter{

    @BindView(R.id.txt4)
    TextView txt4;

    public TabFourthActivity(AppCompatActivity activity, View view) {
        super(activity, view);
    }

    @Override
    public void onCreateView() {

    }
}
