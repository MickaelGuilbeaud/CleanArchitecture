package com.mickaelg.cleanarchitecture.data.mappers;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link PostEntity} (in the data layer) to {@link com.mickaelg.cleanarchitecture.domain.models.Post} in the domain layer.
 */
@Singleton
public class PostEntityDataMapper {

    @Inject
    public PostEntityDataMapper() {
        // Nothing
    }

    /**
     * Transform a {@link PostEntity} into a {@link com.mickaelg.cleanarchitecture.domain.models.Post}.
     * @param postEntity Object to be transformed.
     * @return {@link com.mickaelg.cleanarchitecture.domain.models.Post} if valid {@link PostEntity} otherwise null.
     */
    public com.mickaelg.cleanarchitecture.domain.models.Post transform(PostEntity postEntity) {
        com.mickaelg.cleanarchitecture.domain.models.Post post = null;
        if (postEntity != null) {
            post = new com.mickaelg.cleanarchitecture.domain.models.Post(postEntity.getUserId(),
                    postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getBody());
        }

        return post;
    }


    /**
     * Transform a List of {@link PostEntity} into a Collection of {@link com.mickaelg.cleanarchitecture.domain.models.Post}.
     * @param postEntityCollection Object Collection to be transformed.
     * @return {@link com.mickaelg.cleanarchitecture.domain.models.Post} if valid {@link PostEntity} otherwise null.
     */
    public List<com.mickaelg.cleanarchitecture.domain.models.Post> transform(Collection<PostEntity> postEntityCollection) {
        List<com.mickaelg.cleanarchitecture.domain.models.Post> postList = new ArrayList<>();
        com.mickaelg.cleanarchitecture.domain.models.Post post;
        for (PostEntity postEntity : postEntityCollection) {
            post = transform(postEntity);
            if (post != null) {
                postList.add(post);
            }
        }

        return postList;
    }

}
