package com.mickaelg.cleanarchitecture.domain.repositories;

import com.mickaelg.cleanarchitecture.domain.models.Post;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link Post} related data.
 */
public interface IPostRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link Post}.
     */
    Observable<List<com.mickaelg.cleanarchitecture.domain.models.Post>> posts();

}
