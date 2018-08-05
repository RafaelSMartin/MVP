package com.rafaels.mvpbased.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.rafaels.mvpbased.R;
import com.rafaels.mvpbased.setting.SettingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by INDOGROUP1 on 31/07/2017.
 */

public class HomeFragment extends MvpFragment<HomeView, HomePresenter> implements HomeView {

    public static final int REQUEST_STORAGE_PERMISSION = 0;

    private Context context;
    private HomeView homeView;

    @BindView(R.id.file_type_recycler_view)
    RecyclerView fileTypeRecyclerView;
    FileTypeAdapter fileTypeAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.setting_button)
    ImageView settingImage;

    public static final String TAG = "HomeFragment";


    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(getActivity(), this);
    }

    //Creo el Adaptador FileTypeAdapter
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Para que no se vuelva a instanciar siempre la vista y se superponen y crecen las sombras
        setRetainInstance(true);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);



        fileTypeAdapter = new FileTypeAdapter(null, this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        requestWriteExternalPermission(REQUEST_STORAGE_PERMISSION);
    }

    //Va primero, inflo el fragment y lo muestro
    //Creo un LinearLayoutManager para el Recycler vista y lo seteo
    //despues inserto el adaptador en el recicler view.
    //Devuelvo la vista
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        fileTypeRecyclerView.setLayoutManager(gridLayoutManager);
        fileTypeRecyclerView.setAdapter(fileTypeAdapter);

        fileTypeRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //presenter.onClickPick();
                //presenter.onClickPickResult();
                Toast.makeText(context, "cuando", Toast.LENGTH_LONG).show();


            }
        });

        toolbar.setTitle(R.string.app_name);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        //TODO onClickBack
                        presenter.onClickBack();
                        return true;
                    }
                }
                return false;
            }
        });


        settingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getGrantedWriteExternalPermission()) {
                    presenter.onClickSetting();
                } else {
                    requestWriteExternalPermission(REQUEST_STORAGE_PERMISSION);
                }
            }
        });



        return view;
    }

    //Va despues de que la vista se haya creado
    //Aqui hago las llamadas al presenter
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Muestro y meto los items
        presenter.start();
    }

    //Viene de la Interfaz HomeView
    //Meto en el adaptador los modelos
    @Override
    public void showFileTypes(List<FileTypeModel> fileTypeModels) {
        fileTypeAdapter.setFileTypeModels(fileTypeModels);
    }

    @Override
    public void showSetting() {
        //setting activity
        SettingActivity.startSettingActivity(getActivity());
    }

    @Override
    public void showFileSelectionList(String string) {
        if(string.equals("UNO")){
            Toast.makeText(getActivity(), "El primero", Toast.LENGTH_LONG).show();
        }
        else if(string.equals("DOS")){
            Toast.makeText(getActivity(), "El segundo", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean getGrantedWriteExternalPermission() {
        int permission = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permission == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void requestWriteExternalPermission(int requestCode) {
        Log.d(getClass().getSimpleName(), "requestWriteExternalPermission");

        if (!shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
        } else {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_STORAGE_PERMISSION) {
            Log.d("PERMISSION", "REQUEST_STORAGE_PERMISSION");
            if (grantResults.length != 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.onGrantWritePermission();
                } else {
                    showDenyPermissionAdviceDialog();
                }
            }
        }

    }

    @Override
    public void showDenyPermissionAdviceDialog() {

    }

    @Override
    public void showPromptExitPanel() {
        getActivity().finish();
    }


}
