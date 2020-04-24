#Etapa de Build
FROM maven:3.5.4-jdk-11 AS build
WORKDIR /api

#Copia todo o código
COPY . .

#Define os argumentos

#Driver do banco de dados. Ex.: org.postgresql.Driver
ARG DB_DRIVER
#Banco de dados utilizado. Ex.: postgres
ARG DB_SERVER
ARG DB_HOST
ARG DB_NAME
ARG DB_USERNAME
ARG DB_PASSWORD
#URL do front-end com
ARG FRONT_HOST

#Roda o goal do Maven para empacotamento
RUN mvn package

#Etapa de geração da imagem
FROM fabric8/java-alpine-openjdk11-jre
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter

#Copia os artegatos gerados na etapa anterior
COPY --from=build /api/target/lib/* /deployments/lib/
COPY --from=build /api/target/*-runner.jar /deployments/app.jar 
EXPOSE 8080

# run with user 1001 and be prepared for be running in OpenShift too
RUN adduser -G root --no-create-home --disabled-password 1001 \
  && chown -R 1001 /deployments \
  && chmod -R "g+rwX" /deployments \
  && chown -R 1001:root /deployments
USER 1001

ENTRYPOINT [ "/deployments/run-java.sh" ]