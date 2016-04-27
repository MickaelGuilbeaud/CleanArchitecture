package com.mickaelg.cleanarchitecture.presentation.posts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mickaelg.cleanarchitecture.presentation.R;
import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mickaël on 26/07/2015.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<PostModel> postModels;
    private int itemLayout;

    public PostsAdapter(List<PostModel> postModels, int itemLayout) {
        this.postModels = postModels;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel postModel = postModels.get(position);

        holder.mTvPostTitle.setText(postModel.getTitle());
        holder.mTvPostContent.setText(postModel.getBody());
        holder.mTvUserId.setText(String.valueOf(postModel.getUserId()));
        holder.mTvPostId.setText(String.valueOf(postModel.getId()));
        holder.itemView.setTag(postModel);
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.post_title) TextView mTvPostTitle;
        @Bind(R.id.post_content) TextView mTvPostContent;
        @Bind(R.id.post_user_id) TextView mTvUserId;
        @Bind(R.id.post_id) TextView mTvPostId;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
