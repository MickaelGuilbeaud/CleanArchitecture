package com.mickaelg.cleanarchitecture.data.network;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;
import rx.Observable;

/**
 * Created by mguilbeaud on 30/07/2015.
 */
public class RestAPI implements IRestAPI {

    // region Properties

    private RestAdapter restAdapter;
    private PostAPI postAPI;

    // endregion


    // region Constructors

    public RestAPI() {
        initRestAdapter();
    }

    // endregion


    // region IRestAPI implementation

    @Override
    public Observable<List<PostEntity>> getPostList() {
        return postAPI.getPostList();
    }

    // endregion


    // region initialization

    private void initRestAdapter() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL)
                .setClient(getClient())
                .setConverter(getConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        postAPI = restAdapter.create(PostAPI.class);
    }

    private Client getClient() {
        return new OkClient();
    }

    private Converter getConverter() {
        return new JacksonConverter();
    }

    // endregion

}
