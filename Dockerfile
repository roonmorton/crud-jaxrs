#ARG WAR_FILE=/app/target/crud-jaxrs.war
#ENV WAR_FILE=/app/target/crud-jaxrs.war
#ARG HELLO=hellouw

FROM maven:3.8.3-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean package

# Utilizar una imagen de Payara Server para desplegar la aplicación
FROM payara/micro:5.2022.5-jdk11
COPY --from=build /app/target/crud-jaxrs.war $DEPLOY_DIR


# Agregar el HEALTH CHECK
HEALTHCHECK --interval=3s --timeout=10s \
  CMD curl --fail http://localhost:8080/health || exit 1

EXPOSE 8080