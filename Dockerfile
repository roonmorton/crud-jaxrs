
FROM maven:3.8.3-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn clean package

RUN echo "El archivo WAR se llama: $WAR_FILE"
ENV WAR_FILE /app/target/${war.filename}

FROM payara/micro:5.2022.2-jdk11
#ENV DEPLOY_DIR /opt/payara/deployments
COPY --from=build /app/target/${war.filename} $DEPLOY_DIR
RUN echo "MY_VAR=$WAR_FILE"
EXPOSE 8080