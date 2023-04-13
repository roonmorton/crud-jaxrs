package com.example.crud.network.request;

import jakarta.validation.constraints.NotNull;

public class PostRequest {

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Body is required")
    private String body;

    @NotNull(message = "Published is required")
    private boolean published;

    public PostRequest() {
    }

    public PostRequest(String title, String body, boolean published) {
        this.title = title;
        this.body = body;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

}
