package com.mickaelg.cleanarchitecture.presentation.common.di.modules;

import com.mickaelg.cleanarchitecture.domain.interactors.UseCase;
import com.mickaelg.cleanarchitecture.presentation.common.di.PerActivity;
import com.mickaelg.cleanarchitecture.presentation.posts.presenters.IPostListPresenter;
import com.mickaelg.cleanarchitecture.presentation.posts.presenters.PostListPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides post related collaborators.
 */
@Module
public class PostModule {

    public PostModule() {}

    @Provides @PerActivity
    @Named("postList")
    UseCase provideGetPostsUseCase(com.mickaelg.cleanarchitecture.domain.interactors.GetPostList getPostList) {
        return getPostList;
    }

    @Provides @PerActivity @Named("postListPresenter")
    IPostListPresenter providePostListPresenter(PostListPresenter postListPresenter) {
        return postListPresenter;
    }

}