package com.gapgram;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.framework.permissions.ApplicationPermission;
import com.framework.utility.NetworkState;
import com.gapgram.adapter.PostsAdapter;
import com.gapgram.model.IListResponse;
import com.gapgram.model.IResponse;
import com.gapgram.serviceCaller.WebserviceCaller;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


   private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    RecyclerView horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    private List<StoryItem> data;

    @BindView(R.id.recycler_posts)
    RecyclerView recycler_posts;

    @BindView(R.id.ic_profile)
    AppCompatImageButton ic_profile;

    WebserviceCaller webserviceCaller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webserviceCaller=new WebserviceCaller();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_posts);

        listItems = new ArrayList<>();

        listItems.add(new ListItem("generalEnglish", R.drawable.english, R.drawable.post, "از سری سوالات آزمون UTEPT، پاسخ تست گزینه ۴ صحیح است. تحلیل: تنها جمله که ربط دهنده خالس است گزینه ۴ خواهد بود. ", "با تشکر"));
        listItems.add(new ListItem("generalEnglish", R.drawable.english, R.drawable.post, "گزینه ۴ درست است", "سپاس"));
        listItems.add(new ListItem("generalEnglish", R.drawable.english, R.drawable.post3, "کدامیک از مواردی که زیر آن ها خط کشیده شده از نظر گرامری نادرست است.", "گزینه ۲"));


       // adapter = new MyAdapter(listItems, this);
        //recyclerView.setAdapter(adapter);


        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        data = fill_with_data();


        horizontalAdapter = new HorizontalAdapter(data, getApplication());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
       horizontal_recycler_view.setAdapter(horizontalAdapter);

        getCount();
/*
        if(NetworkState.checkInternetConnection(getApplicationContext()))
        {

        }*/


        try {
            getPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }


       /* if(ApplicationPermission.isStoragePermissionGranted(MainActivity.this))
        {

        }*/


        Dexter.withActivity(MainActivity.this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Log.e("","");
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Log.e("","");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.e("","");
                    }
                }).check();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public List<StoryItem> fill_with_data() {

        List<StoryItem> data = new ArrayList<>();

        data.add(new StoryItem(R.drawable.profilestories, "You"));
        data.add(new StoryItem(R.drawable.english, "English"));
        data.add(new StoryItem(R.drawable.yjcnews, "Yjc"));
        data.add(new StoryItem(R.drawable.digikalacom, "Digikala"));
        data.add(new StoryItem(R.drawable.movafaghiatmag, "Movafaghiat"));


        return data;
    }


    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

        /*private void setupBottomNavigationView() {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);

        }*/


    public void hideKeyboard(Context activityContext) {

        InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        //android.R.id.content ( http://stackoverflow.com/a/12887919/2077479 )
        View rootView = ((Activity) activityContext)
                .findViewById(android.R.id.content).getRootView();

        imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }


    public void showKeyboard(Context activityContext, final EditText editText) {


        final InputMethodManager imm = (InputMethodManager)
                activityContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (!editText.hasFocus()) {
            editText.requestFocus();
        }

        editText.post(new Runnable() {
            @Override
            public void run() {
                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
            }
        });


    }


    @OnClick(R.id.ic_profile)
    public void ic_profile_click() {

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }

    public void getCount(){

        webserviceCaller.getPostCount(new IResponse() {
            @Override
            public void onSuccess(Object responseBody) {
                Log.e("","");
            }

            @Override
            public void onFail() {
                Log.e("","");
            }
        });

    }


    public void getPosts()throws Exception{

        webserviceCaller.getPosts(new IListResponse() {
            @Override
            public void onSuccess(List responseBody) {

                recyclerView.setAdapter(new PostsAdapter(getApplicationContext()
                ,responseBody));

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                ,LinearLayoutManager.VERTICAL,false));

            }

            @Override
            public void onFail() {

            }
        });


    }



}

