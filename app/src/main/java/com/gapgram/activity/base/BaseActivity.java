package com.gapgram.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.framework.utility.FragmentManage;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    FragmentManage fragmentManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        fragmentManage = new FragmentManage();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    //======= fragment method
    public abstract int getFrameLayout();

    public void selectedFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (fragmentManage.getBackStackEntryCount(fragmentManager) >= 1) {
                if (!fragment.getClass().getName().matches(fragmentManage.getFristEntryFragment(fragmentManager, getSupportFragmentManager()).getClass().getName())) {
                    replaceFragment(fragmentManager, fragment);
                } else {
                    Toast.makeText(this, "tekrari click shode", Toast.LENGTH_SHORT).show();
                }
            } else {
                replaceFragment(fragmentManager, fragment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replaceFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(getFrameLayout(),
                fragment, fragment.getClass().toString())
                .addToBackStack(fragment.getClass().toString())
                .commit();
    }

    public void removeFragment() {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManage.getBackStackEntryCount(fragmentManager) >= 1) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.remove(fragmentManage.getFristEntryFragment(fragmentManager, getSupportFragmentManager()));
                ft.commit();
                fragmentManager.popBackStack();
            } else {
                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
