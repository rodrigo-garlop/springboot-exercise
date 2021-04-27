# Spring Boot REST API Exercise (Accounting system simulator)

Rodrigo García López (rodrigo-garlop@outlook.com)

### Technologies 

* Java 11
* Spring boot (REST API/JSON)
* Swagger
* Docker
* Maven
* H2DB and JPA

### Source code

* Clone the repository at *https://github.com/rodrigo-garlop/springboot-exercise*

### Running the application

* Build the docker image with `docker build -t accounting:latest .`, or download it at *https://hub.docker.com/repository/docker/roogar/springboot-exercise*
* Run docker container with `docker run -p 8080:8080 accounting`
* Access the database at *http://localhost:8080/h2-console/*
* Checkout the REST API documentation at *http://localhost:8080/swagger-ui/index.html*
