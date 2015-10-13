package com.mickaelg.cleanarchitecture.domain.interactors;

import com.mickaelg.cleanarchitecture.domain.executor.IThreadExecutor;
import com.mickaelg.cleanarchitecture.domain.models.Post;
import com.mickaelg.cleanarchitecture.domain.repositories.IPostRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of {@link Post}.
 */
public class GetPostList extends UseCase {

    private final IPostRepository postRepository;

    @Inject
    public GetPostList(IPostRepository postRepository,
                       IThreadExecutor threadExecutor,
                       com.mickaelg.cleanarchitecture.domain.executor.IPostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.postRepository = postRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return postRepository.posts();
    }
}
