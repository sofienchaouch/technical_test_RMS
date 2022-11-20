 # Instructions

Technical Test RMS Java Spring Boot

## Envirement

Java 8

JDK 1.8

### Docker Compose

Setup the database and Spring boot Application application with the docker-compose

```bash

# start docker-compose
docker-compose up -d

```

## Swagger ui 

Open swagger UI for testing the APIs


(http://localhost:8080/swagger-ui.html)


Test APIs :

nouvel-air-controller : 
    GET /nouvelair/flights

tunis-air-controller : 
    GET /tunisair/flights

rms-controller : 
    GET /rmsflights/flights



## Local Setup 
First run database container 

```bash
docker-compose up -d db
```

Build the project

```bash

mvn clean install

```

then run the project with your IDE
