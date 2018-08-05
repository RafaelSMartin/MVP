package com.rafaels.firstsamplemvp;

public class AlCuadradoPresenter implements Contract.Presenter{

    private AlCuadradoView view;
    private AlCuadradoModel model;

    public AlCuadradoPresenter(AlCuadradoView view){
        this.view = view;
        model = new AlCuadradoModel(this);
    }

    @Override
    public void alCuadradoPresenter(String data) {
        model.alCuadradoModel(data);
    }

    @Override
    public void showResultPresenter(String result) {
        view.showResultView(result);
    }

    @Override
    public void showErrorPresenter(String error) {
        view.showErrorView(error);
    }


}
