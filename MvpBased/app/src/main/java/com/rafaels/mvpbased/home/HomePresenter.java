package com.rafaels.mvpbased.home;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.MimeTypeMap;


import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.rafaels.mvpbased.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Es el que hace el trabajo duro
 *
 * En este patrón es el encargado de coordinar la implementación de la vista y el modelo,
 * actualiza la vista y actúa sobre los eventos de usuario que se envían por la vista.
 * El presenter también recupera los datos del modelo y los prepara para su visualización.
 */

public class HomePresenter extends MvpBasePresenter<HomeView> {

    private Context context;
    private HomeView homeView;


    public HomePresenter(@NonNull Context context
            , @NonNull final HomeView homeView){
        this.context = context;
        this.homeView = homeView;
    }

    //Mete el item dentro de la lista y los muestra
    void start(){
        if(isViewAttached()) {

            List<FileTypeModel> fileTypeModels = new ArrayList<>();
           /* for(int i = 0; i != 20; ++i)
                fileTypeModels.add(new FileTypeModel((R.mipmap.ic_launcher), R.string.app_name, "OTHER"));*/


            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.uno, "UNO"));
            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.dos, "DOS"));
            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.tres, "TRES"));
            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.cuatro, "CUATRO"));
            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.cinco, "CINCO"));
            fileTypeModels.add(new FileTypeModel(R.mipmap.ic_launcher, R.string.seis, "SEIS"));


            getView().showFileTypes(fileTypeModels);
        }
    }

    //El escuchador del Boton Settings del Toolbar, hace el trabajo duro
    void onClickSetting(){
        if(isViewAttached())
        {
            getView().showSetting();
        }
    }

    public void onGrantWritePermission() {
        //Hacer algo con el permiso concedido
    }

    public void onClickBack(){
        Log.d("presenter", "click back");
        homeView.showPromptExitPanel();
    }

    public void onClickPick() {
        String string = "";
        if(isViewAttached()) {
            getView().showFileSelectionList(string);
        }
    }

}
