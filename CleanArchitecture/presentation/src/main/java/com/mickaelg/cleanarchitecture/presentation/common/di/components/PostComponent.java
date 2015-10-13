package com.mickaelg.cleanarchitecture.presentation.common.di.components;

import com.mickaelg.cleanarchitecture.presentation.common.di.PerActivity;
import com.mickaelg.cleanarchitecture.presentation.common.di.modules.ActivityModule;
import com.mickaelg.cleanarchitecture.presentation.common.di.modules.PostModule;
import com.mickaelg.cleanarchitecture.presentation.posts.fragments.PostsFragment;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects post specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, PostModule.class})
public interface PostComponent extends ActivityComponent {
    void inject(PostsFragment postsFragment);
}
