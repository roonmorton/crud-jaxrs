package com.example.crud.resources;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("post")
public class PostResource {
    
    @GET
    public Response getPosts(){
        return Response
                .ok("ping Jakarta EE")
                .build();
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
