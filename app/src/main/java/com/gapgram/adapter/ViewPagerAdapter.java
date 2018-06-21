package com.gapgram.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.gapgram.Presenter;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by setareh on 6/10/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private final List<Presenter> mPresenterList = new ArrayList<>();

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mPresenterList.size();
    }

    public void addView(Presenter presenter){
        mPresenterList.add(presenter);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View currentView = mPresenterList.get(position).getView();
        return currentView;
    }
}
