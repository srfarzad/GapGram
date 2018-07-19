package com.gapgram.activity.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.gapgram.R;
import com.gapgram.activity.fragments.MainPostsFragment;


/**
 * Created by behzad on 10/11/2017.
 */

public class MainFragmentActivity extends BaseActivity {


    public void initview() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        setupFragment(savedInstanceState);
        clickListener();
    }

    public void setupFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            MainPostsFragment firstFragment = new MainPostsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frm_content_mainFragmentActivity, firstFragment);
            ft.commit();
        }
    }

    @Override
    public int getFrameLayout() {
        return R.id.frm_content_mainFragmentActivity;
    }

    public void clickListener() {

    }

}
