package com.rafaels.sampledagger2.di;

import com.rafaels.sampledagger2.Coche;
import com.rafaels.sampledagger2.Motor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MotorModule {

    @Singleton
    @Named("Diesel")
    @Provides
    public Motor providesMotorDiesel(){
        return new Motor("Diesel");
    }

    @Named("Gasolina")
    @Provides
    public Motor providesMotorGasolina(){
        return new Motor("Gasolina");
    }


    @Provides
    public Coche providesCoche(@Named("Diesel")Motor motor){
        return new Coche(motor);
    }

}
