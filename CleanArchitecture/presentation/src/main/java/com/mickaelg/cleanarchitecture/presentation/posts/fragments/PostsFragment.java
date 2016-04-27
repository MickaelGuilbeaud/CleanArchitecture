package com.mickaelg.cleanarchitecture.presentation.posts.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mickaelg.cleanarchitecture.presentation.R;
import com.mickaelg.cleanarchitecture.presentation.common.activities.BaseActivity;
import com.mickaelg.cleanarchitecture.presentation.common.di.components.DaggerPostComponent;
import com.mickaelg.cleanarchitecture.presentation.common.di.components.PostComponent;
import com.mickaelg.cleanarchitecture.presentation.common.fragments.BaseFragment;
import com.mickaelg.cleanarchitecture.presentation.posts.adapters.PostsAdapter;
import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;
import com.mickaelg.cleanarchitecture.presentation.posts.presenters.IPostListPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mguilbeaud on 23/07/2015.
 */
public class PostsFragment extends BaseFragment implements IPostsView {

    public final static String TAG = PostsFragment.class.getSimpleName();

    // region Properties

    @Bind(R.id.mRecyclerViewPosts)
    RecyclerView mPostsRecyclerView;
    @Bind(R.id.mLoadingPane)
    View mVLoadingPane;

    private RecyclerView.LayoutManager mPostsLayoutManager;
    private RecyclerView.Adapter<PostsAdapter.ViewHolder> mPostsAdapter;

    private PostComponent mPostComponent;
    @Inject
    @Named("postListPresenter")
    IPostListPresenter mPostListPresenter;

    private List<PostModel> mPostsList = new ArrayList<>();

    // endregion


    // region Constructors

    public PostsFragment() {
        // Required empty public constructor
    }

    // endregion


    // region Lifecycle

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_post_list_layout, container, false);
        ButterKnife.bind(this, fragmentView);
        initializeUI();
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeInjector();
        initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPostListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPostListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPostListPresenter.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    // endregion


    // region IPostView implementation

    @Override
    public void showProgress() {
        mVLoadingPane.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mVLoadingPane.setVisibility(View.GONE);
    }

    @Override
    public void setPosts(List<PostModel> postModels) {
        mPostsList.clear();
        mPostsList.addAll(postModels);
        mPostsAdapter.notifyDataSetChanged();
    }

    // endregion


    // region business methods

    private void initializeInjector() {
        if (!(getActivity() instanceof BaseActivity)) {
            return;
        }

        BaseActivity activity = (BaseActivity) getActivity();

        mPostComponent = DaggerPostComponent.builder()
                .applicationComponent(activity.getApplicationComponent())
                .activityModule(activity.getActivityModule())
                .build();
    }

    private void initialize() {
        mPostComponent.inject(this);

        mPostListPresenter.setView(this);
        loadPostList();
    }

    private void initializeUI() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mPostsRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager llManager = new LinearLayoutManager(getActivity());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        mPostsLayoutManager = llManager;
        mPostsRecyclerView.setLayoutManager(mPostsLayoutManager);

        // Set the adapter
        mPostsAdapter = new PostsAdapter(mPostsList, R.layout.listitem_post_layout);
        mPostsRecyclerView.setAdapter(mPostsAdapter);
    }

    private void loadPostList() {
        mPostListPresenter.loadPostList();
    }

    // endregion
}
