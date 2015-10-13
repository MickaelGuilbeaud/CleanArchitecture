package com.mickaelg.cleanarchitecture.data.network;

import com.mickaelg.cleanarchitecture.data.entities.PostEntity;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by mguilbeaud on 30/07/2015.
 */
public interface PostAPI {

    @GET("/posts")
    Observable<List<PostEntity>> getPostList();
}
