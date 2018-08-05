package com.rafaels.mvpbased.setting;


import android.app.Activity;
import android.content.Intent;

import com.rafaels.mvpbased.BasePresenter;
import com.rafaels.mvpbased.BaseView;


/**
 *  Interfaz de Modelo Vista Presentador
 *  Si hacemos algo, aqui hacemos la llamada
 *
 * Una View dentro de MVP no representa una vista del SDK de android (Android class View),
 * es decir no es un TextView, ni un Button, ni un Layout, ni una Custom View, ni mucho menos una Activity o un Fragment.
 *
 * Una View representa una abstracción de que puedo hacer con la vista,
 * normalmente se asocia a una interface para representar la funcionalidad de una vista.
 * La parte importante está en que una Activity o un Fragmento tienen la responsabilidad únicamente de implementar la interface View
 * y conectar las acciones del usuario con el presenter. *
 *
 */

public interface SettingContract {


    interface View extends BaseView<Presenter> {


        void showPlayStoreForApp(int packageName, int appName);
        void openLink(int linkName, int linkId);
        void showContactUs(String message);
        void showCameraTranslatorAdvert();
        void showScannerAdvert();
        void launchIntent(Intent intent);



    }

    interface  Presenter extends BasePresenter {

        void onClickCameraTranslator();
        void onClickTripleTranslator();
        void onClickScanner();
        void onClickMoreApps();
        void onClickWebsite();
        void onClickPrivacyPolicy();
        void onClickContactUs(Activity activity);
        void onClickLaunchCameraTranslator();
        void onClickLaunchScanner();
        void onClickPDFConverter();

    }


}
