package com.gapgram;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.gapgram.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Intent intent;

    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @BindView(R.id.btn_edit)
    AppCompatButton btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        define();
        init();

    }

    public void define() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.beginFakeDrag();

        setupViewPager();

        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.icon_apps));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.icon_list));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.icon_person));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.icon_bookmark));

    }

    public void init() {

        tablayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        tablayout.getTabAt(1).getIcon().clearColorFilter();
        tablayout.getTabAt(2).getIcon().clearColorFilter();
        tablayout.getTabAt(3).getIcon().clearColorFilter();

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                tablayout.getTabAt(0).getIcon().clearColorFilter();
                tab.getIcon().clearColorFilter();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(ProfileActivity.this,EditProfile.class);
                startActivity(intent);
            }
        });

    }

    private void setupViewPager() {

        adapter = new ViewPagerAdapter();

        adapter.addView(new TabFirstActivity(this, findViewById(R.id.layout1)));
        adapter.addView(new TabSecondActivity(this, findViewById(R.id.layout2)));
        adapter.addView(new TabThirdActivity(this, findViewById(R.id.layout3)));
        adapter.addView(new TabFourthActivity(this, findViewById(R.id.layout4)));

        viewPager.setAdapter(adapter);

    }
}
