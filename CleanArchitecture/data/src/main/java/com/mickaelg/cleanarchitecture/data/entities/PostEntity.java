package com.mickaelg.cleanarchitecture.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Post Entity used in the data layer.
 */
public class PostEntity {

    private long userId;
    private long id;
    private String title;
    private String body;

    public PostEntity() {
        // Nothing
    }

    public PostEntity(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @JsonProperty(value = "userId")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty(value = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty(value = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty(value = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
