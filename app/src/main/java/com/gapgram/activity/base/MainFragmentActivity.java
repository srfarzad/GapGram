package com.gapgram.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.gapgram.R;
import com.gapgram.activity.fragments.MainPostsFragment;
import com.gapgram.activity.fragments.ProfileActivity;


/**
 * Created by behzad on 10/11/2017.
 */

public class MainFragmentActivity extends BaseActivity {


    public void initview() {
    }

    AppCompatImageView ic_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        setupFragment(savedInstanceState);
        clickListener();

        ic_camera=findViewById(R.id.ic_camera);


        ic_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);

            }
        });


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
