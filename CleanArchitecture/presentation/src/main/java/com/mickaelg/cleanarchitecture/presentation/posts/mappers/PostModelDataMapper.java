package com.mickaelg.cleanarchitecture.presentation.posts.mappers;

import com.mickaelg.cleanarchitecture.presentation.posts.models.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Simple Mapper mapping Post to PostModel
 */
public class PostModelDataMapper {

    @Inject
    public PostModelDataMapper() {
        // Nothing
    }

    public PostModel transform(com.mickaelg.cleanarchitecture.domain.models.Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        return new PostModel(post.getUserId(),
                post.getId(),
                post.getTitle(),
                post.getBody());
    }

    public List<PostModel> transform(List<com.mickaelg.cleanarchitecture.domain.models.Post> posts) {
        List<PostModel> postsModel;
        if (posts != null && !posts.isEmpty()) {
            postsModel = new ArrayList<>(posts.size());
            for (com.mickaelg.cleanarchitecture.domain.models.Post post : posts) {
                postsModel.add(transform(post));
            }
        } else {
            postsModel = new ArrayList<>(0);
        }
        return postsModel;
    }
}
