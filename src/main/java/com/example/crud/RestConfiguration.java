package com.example.crud;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RestConfiguration extends ResourceConfig {

    public RestConfiguration() {
        packages("com.example.crud.resources");
    }
}
