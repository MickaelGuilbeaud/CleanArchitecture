package com.mickaelg.cleanarchitecture.data.repository.datasource;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;
import com.mickaelg.cleanarchitecture.data.network.RestAPI;

import java.util.List;

import rx.Observable;

/**
 * Created by mguilbeaud on 30/07/2015.
 */
public class NetworkPostDataStore implements PostDataStore {

    private RestAPI restAPI;

    /**
     * Construct a {@link PostDataStore} based on connections to the API.
     *
     * @param restApi The {@link RestAPI} implementation to use.
     */
    public NetworkPostDataStore(RestAPI restApi) {
        this.restAPI = restApi;
    }

    @Override
    public Observable<List<PostEntity>> postEntityList() {
        return restAPI.getPostList();
    }
}
