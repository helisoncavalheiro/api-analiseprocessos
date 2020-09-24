#Etapa de Build
FROM maven:3.5.4-jdk-11 AS build
WORKDIR /api

#Copia todo o código
COPY . .
RUN cd src/main/resources/META-INF/resources \ 
    && openssl genrsa -out publicKey.pem \
    && cd .. \
    && openssl pkcs8 -topk8 -inform PEM -in resources/publicKey.pem -out privateKey.pem -nocrypt \
    && openssl rsa -in resources/publicKey.pem -pubout -outform PEM -out resources/publicKey.pem

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