FROM amazoncorretto:19
MAINTAINER MaxiPisano
COPY target/maxi_pisano-0.0.1-SNAPSHOT.jar maxipisano-app.jar
EXPOSE 8080 
ENTRYPOINT ["java","-jar","/maxipisano-app.jar"]

CMD ["/bin/sh"]
