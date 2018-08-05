package com.rafaels.sampledagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rafaels.sampledagger2.di.MotorApplication;

import javax.inject.Inject;
import javax.inject.Named;

// Video el ejemplo
//https://www.youtube.com/watch?v=oyFhqydqLzM&list=PLN5jmnTStJNi-E0Vm4nr4_2VllWS4LFeu&index=2


public class MainActivity extends AppCompatActivity {

    @Named("Gasolina")@Inject
    Motor motor;

    @Inject
    Coche coche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MotorApplication)getApplication()).getMotorComponent().inject(this);

        Toast.makeText(this, motor.getTipoMotor(), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, coche.getMotor(), Toast.LENGTH_SHORT).show();

    }
}
