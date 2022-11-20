FROM openjdk:8
VOLUME /tmp
COPY target/*.jar technical_test_rms.jar

ADD /src/main/resources/application.properties application.properties

EXPOSE 8080
ENTRYPOINT ["java","-jar","technical_test_rms.jar"]

