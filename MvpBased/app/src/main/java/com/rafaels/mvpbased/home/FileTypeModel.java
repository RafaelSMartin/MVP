package com.rafaels.mvpbased.home;

/**
 * El Modelo del item para FileTypeAdapter
 *
 * Es el proveedor de los datos que queremos mostrar en la vista *
 */

public class FileTypeModel {

    public static final String TYPE_PICTURE = "PICTURE";
    public static final String TYPE_MUSIC = "MUSIC";
    public static final String TYPE_VIDEO = "VIDEO";
    public static final String TYPE_DOCUMENT = "DOCUMENT";
    public static final String TYPE_DOWNLOAD = "DOWNLOAD";
    public static final String TYPE_MINI_BROWSER = "MiniBrowser";



    private int imageId;
    private int text;
    private String type;


    public FileTypeModel(int imageId, int text, String type) {

        this.imageId = imageId;
        this.text = text;
        this.type = type;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getType() { return type; }
}
