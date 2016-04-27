package com.mickaelg.cleanarchitecture.presentation.posts.presenters;

import android.support.annotation.NonNull;

import com.mickaelg.cleanarchitecture.domain.interactors.DefaultSubscriber;
import com.mickaelg.cleanarchitecture.domain.interactors.UseCase;
import com.mickaelg.cleanarchitecture.domain.models.Post;
import com.mickaelg.cleanarchitecture.presentation.posts.fragments.IPostsView;
import com.mickaelg.cleanarchitecture.presentation.posts.mappers.PostModelDataMapper;
import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Presenter managing views implementing the IPostsView interface. It can show or hide a progress dialog and send the
 * view posts to display.
 * The other role of the presenter is to retrieve the data. To do that it use a UseCase that will work in a Thread other
 * than the UI thread.
 * Because the model objects have to be different between the module, it also use a mapper that transform Post in
 * PostModel usable by the views.
 */
public class PostListPresenter implements IPostListPresenter {

    private final static String TAG = PostListPresenter.class.getSimpleName();


    // region Properties

    /**
     * The view to manage
     */
    private IPostsView mPostsView;
    /**
     * UseCase providing the data
     */
    private final UseCase mGetPostsUseCase;
    /**
     * DataMapper mapping Post to PostModel
     */
    private final PostModelDataMapper mPostModelDataMapper;

    // endregion


    // region Constructors

    /**
     * Thanks to the DI, we don't have to instantiate this item ourselves.
     * @param getUserListUserCase getUserListUserCase
     * @param postModelDataMapper postModelDataMapper
     */
    @Inject
    public PostListPresenter(@Named("postList") UseCase getUserListUserCase, PostModelDataMapper postModelDataMapper) {
        this.mGetPostsUseCase = getUserListUserCase;
        this.mPostModelDataMapper = postModelDataMapper;
    }

    // endregion


    // region Presenter lifecycle

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
        // We make sure to unsubscribe when the view is destroyed to avoid memory leak and NPE
        mGetPostsUseCase.unsubscribe();
    }

    // endregion


    // region IPostsPresenter methods implementation

    @Override
    public void setView(@NonNull IPostsView view) {
        this.mPostsView = view;
    }

    @Override
    public void loadPostList() {
        loadPosts();
    }

    // endregion


    // region

    /**
     * Show a progress view
     */
    private void showProgress() {
        mPostsView.showProgress();
    }

    /**
     * Hide a progress view
     */
    private void hideProgress() {
        mPostsView.hideProgress();
    }

    /**
     * Retrieve the post list from the UseCase
     */
    private void loadPosts() {
        showProgress();

        mGetPostsUseCase.execute(new PostListSubscriber());
    }

    /**
     * Transform the Post in PostModel then show them in the view
     * @param posts posts to transform then show
     */
    private void showPosts(List<Post> posts) {
        List<PostModel> postsModel = mPostModelDataMapper.transform(posts);
        mPostsView.setPosts(postsModel);
    }

    // endregion


    // region Subscriber

    /**
     * Callback from our Observable<...>. It is executed in the UIThread.
     */
    private final class PostListSubscriber extends DefaultSubscriber<Post> {

        @Override
        public void onCompleted() {
            PostListPresenter.this.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            PostListPresenter.this.hideProgress();
            // TODO : Show an error SnackBar
            //PostsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            //PostsPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Post modelPosts) {
            PostListPresenter.this.hideProgress();
        }
    }

    // endregion
}
