FROM adoptopenjdk:15_36-jdk-hotspot
RUN mkdir -p /var/log/personal-finance-management-system
VOLUME /tmp
EXPOSE 8080
ADD target/personal-finance-management-system-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]