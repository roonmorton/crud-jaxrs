package com.example.crud;

import com.example.crud.domains.Post;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.core.Response;

@Stateless
public class PostsRepository {

    @PersistenceContext(unitName = "PU_POST")
    private EntityManager em;

    public Response obtenerPosts() {
        return Response.ok(em.createNamedQuery(Post.SELECT_ALL, Post.class).getResultList()).build();
    }
}
