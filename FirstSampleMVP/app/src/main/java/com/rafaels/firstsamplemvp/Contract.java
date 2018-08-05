package com.rafaels.firstsamplemvp;

public interface Contract {

    interface View{
        void showResultView(String result);
        void showErrorView(String error);
    }

    interface Presenter{
        void showResultPresenter(String result);
        void showErrorPresenter(String error);

        void alCuadradoPresenter(String data);

    }

    interface Model{
        void alCuadradoModel(String data);

    }

}
