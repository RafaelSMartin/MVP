package com.rafaels.mvpbased.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;

import com.rafaels.mvpbased.R;


/**
 * Solo carga el Fragment
 * Obtiene el TAG e incluye el fragment y su layout con ActivityUtils
 *
 */

public class SettingFragment extends PreferenceFragmentCompat implements SettingContract.View{

    public static final String TAG = "SettingFragment";

    SettingContract.Presenter settingPresenter;




    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey)
    {
        setPreferencesFromResource(R.xml.pref_general, rootKey);
        initSetting();

    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        getView().setBackgroundColor(Color.WHITE);

        settingPresenter.start();

    }

    public static SettingFragment newInstance(String rootKey)
    {
        Bundle args = new Bundle();
        args.putString(SettingFragment.ARG_PREFERENCE_ROOT, rootKey);
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(SettingContract.Presenter presenter) {
        settingPresenter = presenter;
    }

    private void initSetting()
    {
        //initSettingPref();
        initMoreAppsPref();
        initAboutPref();
    }

    private void initSettingPref()
    {
        Preference pref = findPreference(getString(R.string.default_directory));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //settingPresenter.onClickDefaultDirectory();
                return false;
            }
        });

//        pref = findPreference("RESET_LIMIT");
//        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            public boolean onPreferenceClick(Preference preference) {
//                PrefUtil.reset(getContext());
//                return false;
//            }
//        });

    }

    private void initMoreAppsPref()
    {
        //TODO Subcription option. Uncomment this preferences
//        Preference pref = findPreference(getString(R.string.subscription_1_month_title));
//        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            public boolean onPreferenceClick(Preference preference) {
//                settingPresenter.onClickOneMonthPremium();
//                return false;
//            }
//        });
//
//        pref = findPreference(getString(R.string.subscription_1_year_title));
//        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            public boolean onPreferenceClick(Preference preference) {
//                settingPresenter.onClickOneYearPremium();
//                return false;
//            }
//        });

        Preference pref = findPreference(getString(R.string.camera_translator));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickCameraTranslator();
                return false;
            }
        });
        pref = findPreference(getString(R.string.pdf_converter));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickPDFConverter();
                return false;
            }
        });

        pref = findPreference(getString(R.string.scanner_pdf));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickScanner();
                return false;
            }
        });

        pref = findPreference(getString(R.string.more_app));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickMoreApps();
                return false;
            }
        });
    }

    private void initAboutPref()
    {
        Preference pref = findPreference(getString(R.string.website));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickWebsite();
                return false;
            }
        });

        pref = findPreference(getString(R.string.privacy_policy));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickPrivacyPolicy();
                return false;
            }
        });

        pref = findPreference(getString(R.string.contact_us));
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                settingPresenter.onClickContactUs(getActivity());
                return false;
            }
        });
    }

    @Override
    public void showScannerAdvert()
    {

        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate(R.layout.scanner_advertise_layout, null);

        /*final MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.scanner_pdf)
                .customView(view, true)
                .cancelable(true)
                .build();

        dialog.show();
        //App.getInstance().sendEvent(category, R.string.action_showed, R.string.label_scanner_advertise_panel);

        RelativeLayout scannerLayout = (RelativeLayout)view.findViewById(R.id.scanner_layout);
        scannerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingPresenter.onClickLaunchScanner();
                dialog.dismiss();

            }
        });*/
    }

    @Override
    public void showCameraTranslatorAdvert()
    {

        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate(R.layout.camera_advertise_layout, null);

        /*final MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.camera_translator)
                .customView(view, true)
                .cancelable(true)
                .build();

        dialog.show();
        //App.getInstance().sendEvent(category, R.string.action_showed, R.string.label_scanner_advertise_panel);

        RelativeLayout scannerLayout = (RelativeLayout)view.findViewById(R.id.camera_layout);
        scannerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingPresenter.onClickLaunchCameraTranslator();
                dialog.dismiss();

            }
        });*/
    }

    @Override
    public void showPlayStoreForApp(int packageName, int appName)
    {
        Uri uri = Uri.parse("market://details?id=" + getString(packageName));
        getActivity().startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void showContactUs(String message)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + getString(R.string.contact_us_link)));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        getActivity().startActivity(Intent.createChooser(emailIntent, "Send email"));
    }

    @Override
    public void launchIntent(Intent intent)
    {
        getActivity().startActivity(intent);
    }

    @Override
    public void openLink(int linkName, int linkId)
    {
        String link = getString(linkId);
        Intent browserIntent = new Intent(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse(link)), getString(linkName)));
        getActivity().startActivity(browserIntent);
    }




}
