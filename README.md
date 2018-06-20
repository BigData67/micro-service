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
 
 