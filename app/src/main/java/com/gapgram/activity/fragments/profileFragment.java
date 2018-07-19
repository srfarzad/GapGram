package com.gapgram.activity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapgram.R;
import com.gapgram.adapter.HorizontalAdapter;
import com.gapgram.adapter.PostsAdapter;
import com.gapgram.model.GetUserAllPost;
import com.gapgram.model.IListResponse;
import com.gapgram.model.StoryItem;
import com.gapgram.serviceCaller.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;


public class profileFragment extends Fragment {
    View view;
    HorizontalAdapter horizontalAdapter;
    WebserviceCaller webserviceCaller;


    //empty constractor
    public profileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);


        return view;
    }


}