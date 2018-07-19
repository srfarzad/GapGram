package com.framework.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentManage {

    public Fragment getFristEntryFragment(FragmentManager fragmentManager, FragmentManager getSupportFragmentManager) {
        int index = fragmentManager.getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry backEntry = getSupportFragmentManager.getBackStackEntryAt(index);
        String tag = backEntry.getName();
        Fragment fragment = getSupportFragmentManager.findFragmentByTag(tag);
        return fragment;
    }

    public int getBackStackEntryCount(FragmentManager fragmentManager) {
        int index = fragmentManager.getBackStackEntryCount();
        return index;
    }
}
