
FROM amazoncorretto:19-alpine-jdk
MAINTAINER MaxiPisano
COPY target/maxi_pisano-0.0.1-SNAPSHOT.jar maxipisano-app.jar
ENTRYPOINT ["java","-jar","/maxipisano-app-jar"]

CMD ["/bin/sh"]
