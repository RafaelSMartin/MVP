package com.rafaels.mvpbased.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.rafaels.mvpbased.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptador de tipo RecyclerView
 */

public class FileTypeAdapter extends RecyclerView.Adapter<FileTypeAdapter.FileTypeViewHolder> {

    List<FileTypeModel> fileTypeModels;

    private HomeView homeView;

    //Constructor
    public FileTypeAdapter(List<FileTypeModel> fileTypeModels, @NonNull HomeView homeView) {
        this.fileTypeModels = fileTypeModels;
        this.homeView = homeView;
    }

    //Setteo los items
    public void setFileTypeModels(List<FileTypeModel> fileTypeModels) {
        this.fileTypeModels = fileTypeModels;
        //Actualiza la lista
        notifyDataSetChanged();
    }

    //Creo y devuelvo la vista
    @Override
    public FileTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ConvertedFileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.converted_file_item, parent, false),

        return new FileTypeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.file_type_item_layout, parent, false));
    }

    //Mete en la vista el item correspondiente
    @Override
    public void onBindViewHolder(FileTypeViewHolder holder, int position) {
        holder.bind(fileTypeModels.get(position));
    }

    //Devuelve el total de los items
    @Override
    public int getItemCount() {
        return fileTypeModels.size();
    }

    //Clase ViewHolder del RecyclerView
    public class FileTypeViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.file_type_text_view)
        TextView fileTypeTextView;

        @BindView(R.id.file_type_image_view)
        ImageView fileTypeImageView;

        @BindView(R.id.file_type_layout_item)
        RelativeLayout fileTypeLayout;

        //Constructor que guarda los elementos del layout en itemView que usare despues
        public FileTypeViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        //Hacemos los setters de los elementos del items
        public void bind(final FileTypeModel fileTypeModel)
        {
            fileTypeTextView.setText(fileTypeModel.getText());
            fileTypeImageView.setImageResource(fileTypeModel.getImageId());



            //Es Layout completo del adaptador
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    homeView.showFileSelectionList(fileTypeModel.getType());
                }
            });
        }
    }


}
