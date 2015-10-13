package com.mickaelg.cleanarchitecture.data.repository;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;
import com.mickaelg.cleanarchitecture.data.mappers.PostEntityDataMapper;
import com.mickaelg.cleanarchitecture.data.repository.datasource.PostDataStore;
import com.mickaelg.cleanarchitecture.data.repository.datasource.PostDataStoreFactory;
import com.mickaelg.cleanarchitecture.domain.models.Post;
import com.mickaelg.cleanarchitecture.domain.repositories.IPostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by mguilbeaud on 28/07/2015.
 */
@Singleton
public class PostDataRepository implements IPostRepository {

    private static final String TAG = PostDataRepository.class.getSimpleName();

    private final PostDataStoreFactory mPostDataStoreFactory;
    private final PostEntityDataMapper mPostEntityDataMapper;

    @Inject
    public PostDataRepository(PostDataStoreFactory postDataStoreFactory, PostEntityDataMapper postEntityDataMapper) {
        this.mPostDataStoreFactory = postDataStoreFactory;
        this.mPostEntityDataMapper = postEntityDataMapper;
    }

    @Override
    public Observable<List<Post>> posts() {
        PostDataStore postDataStore = mPostDataStoreFactory.create();
        Observable<List<PostEntity>> postEntities = postDataStore.postEntityList();
        Observable<List<Post>> posts = postEntities.map(new Func1<List<PostEntity>, List<Post>>() {
            @Override
            public List<Post> call(List<PostEntity> postEntities) {
                return mPostEntityDataMapper.transform(postEntities);
            }
        });
        return posts;
    }
}
