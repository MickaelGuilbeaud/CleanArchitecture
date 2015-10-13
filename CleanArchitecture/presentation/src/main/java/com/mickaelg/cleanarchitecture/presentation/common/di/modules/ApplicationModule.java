package com.mickaelg.cleanarchitecture.presentation.common.di.modules;

import android.content.Context;

import com.mickaelg.cleanarchitecture.data.executor.JobExecutor;
import com.mickaelg.cleanarchitecture.data.repository.PostDataRepository;
import com.mickaelg.cleanarchitecture.domain.executor.IThreadExecutor;
import com.mickaelg.cleanarchitecture.domain.repositories.IPostRepository;
import com.mickaelg.cleanarchitecture.presentation.common.AndroidApplication;
import com.mickaelg.cleanarchitecture.presentation.common.UIThread;
import com.mickaelg.cleanarchitecture.presentation.common.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides @Singleton
    IThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    com.mickaelg.cleanarchitecture.domain.executor.IPostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    IPostRepository providePostRepository(PostDataRepository postDataRepository) {
        return postDataRepository;
    }

}
