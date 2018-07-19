package com.gapgram.activity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapgram.adapter.HorizontalAdapter;
import com.gapgram.R;
import com.gapgram.model.StoryItem;
import com.gapgram.adapter.PostsAdapter;
import com.gapgram.model.GetUserAllPost;
import com.gapgram.model.IListResponse;
import com.gapgram.serviceCaller.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;


public class MainPostsFragment extends Fragment {
    View view;
    HorizontalAdapter horizontalAdapter;
    WebserviceCaller webserviceCaller;


    //init view
    RecyclerView rv_post_mainPosts;
    RecyclerView rv_stories_mainPosts;

    //empty constractor
    public MainPostsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_posts, container, false);
        rv_post_mainPosts = view.findViewById(R.id.rv_post_mainPosts);
//        setupRvStories(rv_stories_mainPosts);
        webserviceCaller = new WebserviceCaller();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            getUserAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //stories
    public List<StoryItem> fill_with_data() {
        List<StoryItem> data = new ArrayList<>();
        data.add(new StoryItem(R.drawable.profilestories, "You"));
        data.add(new StoryItem(R.drawable.english, "English"));
        data.add(new StoryItem(R.drawable.yjcnews, "Yjc"));
        data.add(new StoryItem(R.drawable.digikalacom, "Digikala"));
        data.add(new StoryItem(R.drawable.movafaghiatmag, "Movafaghiat"));
        return data;
    }

    public void setupRvStories(RecyclerView rv) {
        List<StoryItem> data = fill_with_data();
        horizontalAdapter = new HorizontalAdapter(data, getActivity());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(horizontalLayoutManager);
        rv.setAdapter(horizontalAdapter);
    }

    //posts
    public void getUserAllPosts() throws Exception {

        webserviceCaller.getUserAllPosts(new IListResponse() {
            @Override
            public void onSuccess(List responseBody) {
                Log.d("all", "onSuccess: " + responseBody);
                try {
                    setupRecycler(rv_post_mainPosts, responseBody);
                } catch (Exception e) {
                    Log.d("all", "setAdapter: ");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail() {
                Log.d("all", "onFail: ");
            }
        });

    }

    private void setupRecycler(RecyclerView rv, List<GetUserAllPost> getUserAllPosts) {
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        PostsAdapter postsAdapter = new PostsAdapter(getActivity());
        rv.setAdapter(postsAdapter);
        postsAdapter.setPosts(getUserAllPosts);


    }
}