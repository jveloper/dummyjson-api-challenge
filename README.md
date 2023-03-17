# DummyJson API Challenge

This is a sample Java / Maven / Spring Boot (version 3) application to respond to the proposed challenge. I chose the reactive programming instead of tradicional Spring MVC option for this project in order to show that I can also have these concepts for future projects. So i use with Spring Webflux framework.

DummyJSON (https://dummyjson.com/) was chosen for external calls.

## How to Run

#### With Docker

* Clone this repository
* Make sure you are using JDK 17
* package application with ```mvn clean package```
* build docker image ```docker build -t dummyjson-api-challenge:v1 .```
* Run container ```docker run -d -p 8081:8081 --name dummyjson-api-challenge:v1```


#### Using Maven Plugin

* Clone this repository
* ```mvn spring-boot:run```

#### Using Command Line

* Clone this repository
* ```mvn clean package```
* ```java -jar target/thortful-code-challenge-0.0.1-SNAPSHOT.jar```


## How to Use

Application is running on port 8081 (http://localhost:8081)

## Resources/Endpoints to explore

Swagger documentation http://localhost:8081/swagger-ui.html

## Notes


* Made with hapiness
* With a little imagination
* with likely updates in the coming hours and days


