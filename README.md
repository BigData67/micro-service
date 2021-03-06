# micro-service

## Commit Spring Boot(eclipse) + Mysql (docker via docker-compose)
- Lancer Mysql via docker-compose.yml
- Lancer l'application ecom-catalogs via eclipse
- http://localhost:8080/categories dans un navigateur

## Spring Boot(docker) + Mysql (docker) + Docker-compose for all
 - Adding Dockerfile
 - Configure spotify plugin in pom.xml
 - Update docker-compose
 - Update application.properties
 - cd to ecom-catalogs and execute : ./mvnw install dockerfile:build
 - docker-compose up
 - dans un navigateur http://localhost:8180/categories
 
 
## Adding swagger
 - Adding swagger dependency in pom.xml
 - Adding SwaggerConfig
 - Update ecom-catalogs from 8180 -> 8080 in docker-compose
 - Test with : http://localhost:8080/swagger-ui.html
 
## Adding Eureka
 - Create ecom-registry project
 - Adding dependency listed in pom.xml from ecom-registry
 - Adding @EnableEurekaServer to Application.java from ecom-registry
 - Setting eureka.client.service-url.defaultZone to application.properties from ecom-registry
 - Add Dockerfile to ecom-registry
 - Edit pom.xml from ecom-catalogs
 	o Add spring-cloud-starter-eureka
 - Edit CategoryApi and ProductApi from ecom-service
 	o Adding @EnableEurekaClient on both 
 - Update docker-compose and link all
 
## Adding Zuul
 - Creating ecom-gateway project
 - Configure pom.xml of ecom-gateway
 - Configure routing in application.yml
 - Adding @EnableZuulProxy to Application.java
 - Build image with the commande ./mvnw install dockerfile:build
 - Configure project in docker-compose.yml
 - Test dans un navigateur http://localhost:9000/api/cat/categories
 
 