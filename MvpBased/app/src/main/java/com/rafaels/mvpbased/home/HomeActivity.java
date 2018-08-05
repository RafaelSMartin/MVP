package com.rafaels.mvpbased.home;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


import com.rafaels.mvpbased.R;
import com.rafaels.mvpbased.util.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.fragment_root)
    RelativeLayout fragmentRoot;


    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //After setContentView always XD
        ButterKnife.bind(this);


        homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
        if(homeFragment == null)
        {
            homeFragment = new HomeFragment();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment, R.id.fragment_root, HomeFragment.TAG);
        }

    }




}
