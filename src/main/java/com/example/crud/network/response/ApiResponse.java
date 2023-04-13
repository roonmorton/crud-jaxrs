package com.example.crud.network.response;

import com.example.crud.domains.Post;
import java.util.List;

public class ApiResponse {

    private int code = 0;

    private String message = "Success";

    private List<Post> posts;

    public ApiResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

}
