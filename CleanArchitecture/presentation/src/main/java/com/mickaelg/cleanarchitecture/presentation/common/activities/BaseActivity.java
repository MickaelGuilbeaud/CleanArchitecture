package com.mickaelg.cleanarchitecture.presentation.common.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.mickaelg.cleanarchitecture.presentation.common.AndroidApplication;
import com.mickaelg.cleanarchitecture.presentation.common.di.components.ApplicationComponent;
import com.mickaelg.cleanarchitecture.presentation.common.di.modules.ActivityModule;
import com.mickaelg.cleanarchitecture.presentation.common.navigator.Navigator;

import javax.inject.Inject;

/**
 * Base {@link Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends FragmentActivity {

    // region properties

    @Inject
    Navigator navigator;

    // endregion


    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    // endregion


    // region DI

    /**
     * Get the Main Application component for dependency injection.
     * @return {@link ApplicationComponent}
     */
    public ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     * @return {@link ActivityModule}
     */
    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    // endregion

}