package com.rafaels.firstsamplemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlCuadradoView extends AppCompatActivity implements Contract.View{

    private EditText edInsert;
    private TextView tvResult;
    private Button bAlCuadrado;

    private AlCuadradoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_cuadrado_view);

        edInsert = (EditText)findViewById(R.id.ed_numero);
        tvResult = (TextView)findViewById(R.id.result);
        bAlCuadrado = (Button)findViewById(R.id.button_al_cuadrado);

        presenter = new AlCuadradoPresenter(this);

        bAlCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.alCuadradoPresenter(edInsert.getText().toString());
            }
        });

    }


    @Override
    public void showResultView(String result) {
        tvResult.setText(result);
    }

    @Override
    public void showErrorView(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
