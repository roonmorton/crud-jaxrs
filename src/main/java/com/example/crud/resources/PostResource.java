package com.example.crud.resources;

import com.example.crud.repositories.PostsRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("post")
@RequestScoped
public class PostResource {

    @Inject
    PostsRepository postsRepository;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPosts() {
        return postsRepository.obtenerPosts();
    }
    /*
    
    @POST
    public Response savePost(){
        
    }
    
    
    @PUT 
    public Response updatePost(){
        
        
    }
    
    
    @DELETE 
    public Response deletePost(){
        
    }*/
}
