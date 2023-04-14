package com.example.crud.health;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class LivenessHealthCheck implements HealthCheck {

    private String time;

    @PostConstruct
    private void init() {
        this.time = LocalDateTime.now().toString();
    }

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.builder().name("Liveness Check")
                .withData("status", "ALIVE")
                .withData("from", time)
                .build();

    }

}
