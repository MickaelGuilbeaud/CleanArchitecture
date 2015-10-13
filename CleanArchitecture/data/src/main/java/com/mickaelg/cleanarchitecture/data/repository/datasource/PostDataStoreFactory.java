package com.mickaelg.cleanarchitecture.data.repository.datasource;

import com.mickaelg.cleanarchitecture.data.network.RestAPI;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link PostDataStore}.
 */
@Singleton
public class PostDataStoreFactory {

    @Inject
    public PostDataStoreFactory() {
        // Nothing
    }

    public PostDataStore create() {
        return new NetworkPostDataStore(new RestAPI());
    }

}
