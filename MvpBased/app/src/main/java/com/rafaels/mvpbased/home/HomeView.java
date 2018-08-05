package com.rafaels.mvpbased.home;
import android.content.Intent;
import android.net.Uri;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


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


public interface HomeView extends MvpView {

    void showFileTypes(List<FileTypeModel> fileTypeModels);

    void showSetting();

    void showFileSelectionList(String string);

    void showDenyPermissionAdviceDialog();

    boolean getGrantedWriteExternalPermission();

    void requestWriteExternalPermission(int requestCode);

    void showPromptExitPanel();


}