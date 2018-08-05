package com.rafaels.sampledagger2.di;

import com.rafaels.sampledagger2.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = MotorModule.class)
public interface MotorComponent {
    void inject(MainActivity mainActivity);
}
