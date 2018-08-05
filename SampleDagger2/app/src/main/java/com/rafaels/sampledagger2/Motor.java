package com.rafaels.sampledagger2;

public class Motor {
    private String tipoMotor;

    public Motor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getTipoMotor(){
        return ("Motor: "+tipoMotor);
    }
}
