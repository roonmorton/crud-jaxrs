package com.example.crud.repositories;

import com.example.crud.domains.Post;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

@Stateless
public class PostsRepository {

    @PersistenceContext(unitName = "PU_POST")
    private EntityManager em;

    public Response obtenerPosts() {
        return Response.ok(em.createNamedQuery(Post.SELECT_ALL, Post.class).getResultList()).build();
    }
}
