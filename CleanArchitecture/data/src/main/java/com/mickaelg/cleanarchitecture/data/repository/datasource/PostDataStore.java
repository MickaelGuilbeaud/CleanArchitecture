package com.mickaelg.cleanarchitecture.data.repository.datasource;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface PostDataStore {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link PostEntity}.
     */
    Observable<List<PostEntity>> postEntityList();

}
