package com.example.crud.repositories;

import com.example.crud.domains.Post;
import com.example.crud.network.response.ApiResponse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

@Stateless
public class PostsRepository {

    @PersistenceContext(unitName = "PU_POST")
    private EntityManager em;

    public Response obtenerPosts() {
        ApiResponse res = new ApiResponse();
        res.setPosts(em.createNamedQuery(Post.SELECT_ALL, Post.class).getResultList());
        return Response.ok(res).build();
    }
}
