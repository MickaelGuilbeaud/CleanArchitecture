package com.mickaelg.cleanarchitecture.presentation.posts.fragments;


import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;

import java.util.List;

/**
 * Created by mguilbeaud on 23/07/2015.
 */
public interface IPostsView {

    /**
     * Show the progress view
     */
    void showProgress();

    /**
     * Hide the progress view
     */
    void hideProgress();

    void setPosts(List<PostModel> postModels);
}
