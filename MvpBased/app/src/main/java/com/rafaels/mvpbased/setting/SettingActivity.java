package com.rafaels.mvpbased.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;


import com.rafaels.mvpbased.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Solo carga el Fragment
 * Obtiene el TAG e incluye el fragment y su layout con ActivityUtils
 *
 */

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.setting_fragment_root)
    RelativeLayout settingFragmentRoot;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    SettingFragment settingFragment;



    public static void startSettingActivity(Activity startingActivity)
    {
        Intent intent = new Intent(startingActivity, SettingActivity.class);
        startingActivity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //After setContentView always XD
        ButterKnife.bind(this);

        //Carga de elementos en toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.settings));



        settingFragment = (SettingFragment)getSupportFragmentManager().findFragmentByTag(SettingFragment.TAG);
        if(settingFragment == null)
        {
            settingFragment = new SettingFragment();
            //ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), settingFragment, R.id.setting_fragment_root);
            // Create the fragment
            settingFragment = SettingFragment.newInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.setting_fragment_root, settingFragment, SettingFragment.TAG).commit();
            new SettingPresenter(this, settingFragment);
            Log.d("setting", "create setting fragment");


        }
    }

    //Carga de items toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}
