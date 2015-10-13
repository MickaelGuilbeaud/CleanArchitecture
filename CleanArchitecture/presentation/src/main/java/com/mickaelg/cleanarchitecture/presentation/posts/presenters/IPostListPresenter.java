package com.mickaelg.cleanarchitecture.presentation.posts.presenters;

import android.support.annotation.NonNull;

import com.mickaelg.cleanarchitecture.presentation.common.presenter.IBasePresenter;
import com.mickaelg.cleanarchitecture.presentation.posts.fragments.IPostsView;

/**
 * Interface of the PostListPresenter. Hold the methods for interacting with the presenter.
 */
public interface IPostListPresenter extends IBasePresenter {

    /**
     * Set the view that the Presenter will manage.
     * @param view View to manage
     */
    void setView(@NonNull IPostsView view);

    /**
     * Load a list of post. Return type is void because the process is asynchronous.
     */
    void loadPostList();
}
