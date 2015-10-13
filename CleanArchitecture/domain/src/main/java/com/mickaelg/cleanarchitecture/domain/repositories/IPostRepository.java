package com.mickaelg.cleanarchitecture.domain.repositories;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link com.mickaelg.cleanarchitecture.domain.models.Post} related data.
 */
public interface IPostRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link com.mickaelg.cleanarchitecture.domain.models.Post}.
     */
    Observable<List<com.mickaelg.cleanarchitecture.domain.models.Post>> posts();

}
