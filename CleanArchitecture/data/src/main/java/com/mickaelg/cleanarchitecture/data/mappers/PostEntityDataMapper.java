package com.mickaelg.cleanarchitecture.data.mappers;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;
import com.mickaelg.cleanarchitecture.domain.models.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link PostEntity} (in the data layer) to {@link Post} in the domain layer.
 */
@Singleton
public class PostEntityDataMapper {

    @Inject
    public PostEntityDataMapper() {
        // Nothing
    }

    /**
     * Transform a {@link PostEntity} into a {@link Post}.
     * @param postEntity Object to be transformed.
     * @return {@link Post} if valid {@link PostEntity} otherwise null.
     */
    public Post transform(PostEntity postEntity) {
        Post post = null;
        if (postEntity != null) {
            post = new Post(postEntity.getUserId(),
                    postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getBody());
        }

        return post;
    }


    /**
     * Transform a List of {@link PostEntity} into a Collection of {@link Post}.
     * @param postEntityCollection Object Collection to be transformed.
     * @return {@link Post} if valid {@link PostEntity} otherwise null.
     */
    public List<Post> transform(Collection<PostEntity> postEntityCollection) {
        List<Post> postList = new ArrayList<>();
        Post post;
        for (PostEntity postEntity : postEntityCollection) {
            post = transform(postEntity);
            if (post != null) {
                postList.add(post);
            }
        }

        return postList;
    }

}
