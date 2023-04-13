package com.example.crud.resources;

import com.example.crud.repositories.PostsRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

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
