package com.rafaels.mvpbased.setting;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rafaels.mvpbased.R;
import com.rafaels.mvpbased.util.ActivityUtils;

import github.nisrulz.easydeviceinfo.base.EasyAppMod;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;


/**
 * Es el que hace el trabajo duro
 *
 * En este patrón es el encargado de coordinar la implementación de la vista y el modelo,
 * actualiza la vista y actúa sobre los eventos de usuario que se envían por la vista.
 * El presenter también recupera los datos del modelo y los prepara para su visualización.
 */

public class SettingPresenter implements SettingContract.Presenter {


    private SettingContract.View settingView;
    private Context context;

    public SettingPresenter(@NonNull Context context, @NonNull final SettingContract.View settingView)
    {
        this.context = context;
        this.settingView = settingView;
        settingView.setPresenter(this);

    }

    @Override
    public void start() {

    }

    @Override
    public void onClickCameraTranslator() {
        settingView.showPlayStoreForApp(R.string.camera_translator_package, R.string.camera_translator);

        if(ActivityUtils.isAppInstalled(context, context.getString(R.string.camera_translator_package))) {
            onClickLaunchCameraTranslator();
        }
        else
            settingView.showCameraTranslatorAdvert();
    }

    @Override
    public void onClickLaunchCameraTranslator() {
        if(ActivityUtils.isAppInstalled(context, context.getString(R.string.camera_translator_package)))
        {
            Intent intent = new Intent();
            String cameraPackage = context.getString(R.string.camera_translator_package);
            intent.setComponent(new ComponentName(cameraPackage, cameraPackage + ".SplashActivity"));
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
            settingView.launchIntent(intent);
        }
        else
        {
            settingView.showPlayStoreForApp(R.string.camera_translator_package, R.string.camera_translator);
        }
    }

    @Override
    public void onClickWebsite() {
        settingView.openLink(R.string.website, R.string.website_link);
    }

    @Override
    public void onClickContactUs(Activity activity) {
        String message = "";

        EasyAppMod easyAppMod = new EasyAppMod(activity);
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(activity);

        message += "------------------------";
        message += "\nDevice information";
        message += "\n\n" + easyAppMod.getAppName() + ", Version: " + easyAppMod.getAppVersion();
        message += "\nDevice: " + easyDeviceMod.getDevice();
        message += "\nManufacturer: " + easyDeviceMod.getManufacturer();
        message += "\nOS Version: " + easyDeviceMod.getOSVersion();
        message += "\nOS Codename: " + easyDeviceMod.getOSCodename();
        message += "\n------------------------\n\n";

        settingView.showContactUs(message);
    }

    @Override
    public void onClickLaunchScanner() {
        String packageName = "com.ticktalk.scannerdocument";
        if(ActivityUtils.isAppInstalled(context, packageName))
        {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, "ticktalk.scannerdocument.activity.MainActivity"));
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
            settingView.launchIntent(intent);
        }
        else
        {
            settingView.showPlayStoreForApp(R.string.scanner_package, R.string.scanner_pdf);
        }
    }

    @Override
    public void onClickPrivacyPolicy() {
        settingView.openLink(R.string.privacy_policy, R.string.privacy_policy_link);
    }

    @Override
    public void onClickPDFConverter() {
        String packageName = "com.ticktalk.pdfconverter";
        if(ActivityUtils.isAppInstalled(context, packageName))
        {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, "com.ticktalk.pdfconverter.home.HomeActivity"));
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
            settingView.launchIntent(intent);
        }
        else
        {
            settingView.showPlayStoreForApp(R.string.pdfconverter_package, R.string.pdf_converter);
        }
    }

    @Override
    public void onClickMoreApps() {
        settingView.openLink(R.string.more_app, R.string.more_app_link);
    }

    @Override
    public void onClickScanner() {
        settingView.showPlayStoreForApp(R.string.scanner_package, R.string.scanner_pdf);

        if(ActivityUtils.isAppInstalled(context, context.getString(R.string.scanner_package)))
        {
            onClickLaunchScanner();
        }
        else
            settingView.showScannerAdvert();
    }

    @Override
    public void onClickTripleTranslator() {
        settingView.showPlayStoreForApp(R.string.triple_translator_package, R.string.triple_translator);
    }

}
