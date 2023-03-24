
FROM amazoncorretto:19-alpine-jdk
MAINTAINER MaxiPisano
COPY target/maxi_pisano-0.0.1-SNAPSHOT.jar maxi_pisano-app.jar
ENTRYPOINT ["java","-jar","/maxi_pisano-app.jar"]

CMD ["/bin/sh"]
