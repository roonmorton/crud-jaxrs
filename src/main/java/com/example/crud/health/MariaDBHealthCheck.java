package com.example.crud.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Liveness
@ApplicationScoped
public class MariaDBHealthCheck implements HealthCheck {

    @PersistenceContext(unitName = "PU_POST")
    private EntityManager em;

    @Override
    public HealthCheckResponse call() {
        try {
            //EntityManager em = em.createEntityManager();
            em.createNativeQuery("SELECT 1").getSingleResult();

            return HealthCheckResponse.builder()
                    .name("DataBase Check")
                    .up()
                    .withData("status", "ALIVE")
                    //.withData("from", time)
                    .build();
            //return HealthCheckResponse.named("Database connection health check").up().build();
        } catch (Exception ex) {
            //return HealthCheckResponse.named("Database connection health check").down().build();
            return HealthCheckResponse.builder()
                    .name("DataBase Check")
                    .down()
                    .withData("status", "DOWN")
                    //.withData("from", time)
                    .build();
        }
    }
}
