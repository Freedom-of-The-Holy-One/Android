package com.example.administrator.demo3;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class Third extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private CollapsingToolbarLayout mToolbarLayout;
    private LinearLayout  mLinearLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        AppBarLayout appBarLayout= (AppBarLayout) findViewById(R.id.app_bar);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mLinearLayout= (LinearLayout) findViewById(R.id.head);
        mCoordinatorLayout= (CoordinatorLayout) findViewById(R.id.root);
        mToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.tool_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mLinearLayout.getHeight() / 2) {
                    mToolbarLayout.setTitle("测试");
                } else {
                    mToolbarLayout.setTitle(" ");
                }
            }
        });
    }
}
