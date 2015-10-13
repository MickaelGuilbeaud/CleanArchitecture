package com.mickaelg.cleanarchitecture.presentation.posts.presenters;

import android.support.annotation.NonNull;

import com.mickaelg.cleanarchitecture.domain.interactors.UseCase;
import com.mickaelg.cleanarchitecture.domain.models.Post;
import com.mickaelg.cleanarchitecture.presentation.posts.fragments.IPostsView;
import com.mickaelg.cleanarchitecture.presentation.posts.mappers.PostModelDataMapper;
import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * PostListPresenter sending fake posts to test the UI. Not used anymore.
 * Created by mguilbeaud on 29/07/2015.
 */
@Deprecated
public class FakePostListPresenter implements IPostListPresenter {

    // region Properties

    private IPostsView mPostsView;
    private final UseCase mGetPostsUseCase;
    private final PostModelDataMapper mPostModelDataMapper;

    // endregion


    // region Constructor

    @Inject
    public FakePostListPresenter(@Named("postList") UseCase getUserListUserCase,
                                 PostModelDataMapper postModelDataMapper) {
        this.mGetPostsUseCase = getUserListUserCase;
        this.mPostModelDataMapper = postModelDataMapper;
    }

    // endregion


    // region Presenter lifecycle

    public void setView(@NonNull IPostsView view) {
        this.mPostsView = view;
    }

    @Override
    public void resume() {
        // Nothing
    }

    @Override
    public void pause() {
        // Nothing
    }

    @Override
    public void destroy() {
        mGetPostsUseCase.unsubscribe();
    }

    // endregion


    // region IPostsPresenter methods implementation

    @Override
    public void loadPostList() {
        loadPosts();
    }

    // endregion


    // region business methods

    private void showProgress() {
        mPostsView.showProgress();
    }

    private void hideProgress() {
        mPostsView.hideProgress();
    }

    private void loadPosts() {
        showProgress();

        List<PostModel> postModels = new ArrayList<>();
        final int nbPosts = 10;
        for (int i = 0; i < nbPosts; i++) {
            postModels.add(new PostModel(i, i,
                    "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                    "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut " +
                            "quas totam nostrum rerum est autem sunt rem eveniet architecto"));
        }

        hideProgress();
        mPostsView.setPosts(postModels);
    }

    private void showPosts(List<Post> posts) {
        List<PostModel> postsModel = mPostModelDataMapper.transform(posts);
        mPostsView.setPosts(postsModel);
    }

    // endregion

}
