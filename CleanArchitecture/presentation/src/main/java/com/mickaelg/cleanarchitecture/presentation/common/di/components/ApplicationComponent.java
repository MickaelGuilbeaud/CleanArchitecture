package com.mickaelg.cleanarchitecture.presentation.common.di.components;

import android.content.Context;

import com.mickaelg.cleanarchitecture.domain.executor.IPostExecutionThread;
import com.mickaelg.cleanarchitecture.domain.executor.IThreadExecutor;
import com.mickaelg.cleanarchitecture.domain.repositories.IPostRepository;
import com.mickaelg.cleanarchitecture.presentation.common.activities.BaseActivity;
import com.mickaelg.cleanarchitecture.presentation.common.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    IThreadExecutor threadExecutor();

    IPostExecutionThread postExecutionThread();

    IPostRepository postRepository();

}
