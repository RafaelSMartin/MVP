package com.rafaels.sampledagger2;

public class Coche {
    private Motor motor;

    public Coche(Motor motor) {
        this.motor = motor;
    }

    public String getMotor(){
        return ("Coche con: "+motor.getTipoMotor());
    }
}
