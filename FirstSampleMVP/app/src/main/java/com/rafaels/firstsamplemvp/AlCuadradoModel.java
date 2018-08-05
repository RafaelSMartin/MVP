package com.rafaels.firstsamplemvp;

public class AlCuadradoModel implements Contract.Model {

    private AlCuadradoPresenter presenter;
    private double result;

    public AlCuadradoModel(AlCuadradoPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void alCuadradoModel(String data) {
        if (data.equals("")) {
            presenter.showErrorPresenter("Campo vacio");
        } else {
            result = Double.valueOf(data) * Double.valueOf(data);
            presenter.showResultPresenter(String.valueOf(result));
        }
    }
}
