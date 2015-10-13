package com.mickaelg.cleanarchitecture.presentation.common;

import android.app.Application;

import com.mickaelg.cleanarchitecture.presentation.common.di.components.ApplicationComponent;
import com.mickaelg.cleanarchitecture.presentation.common.di.components.DaggerApplicationComponent;
import com.mickaelg.cleanarchitecture.presentation.common.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
