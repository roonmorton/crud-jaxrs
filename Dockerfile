ARG WAR_FILE=/app/target/${war.filename}

FROM maven:3.8.3-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean package

RUN mvn clean package && echo "El archivo WAR se llama: ${WAR_FILE}"

# Utilizar una imagen de Payara Server para desplegar la aplicación
FROM payara/micro:5.2022.2-jdk11
COPY --from=build $WAR_FILE $DEPLOY_DIR

# Imprimir el valor de la variable WAR_FILE
RUN echo "WAR_FILE=$WAR_FILE"

EXPOSE 8080