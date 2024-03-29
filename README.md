# *PR-edictions*
## A one-stop shop for runners to:
### - Find a coach
### - Communicate running goals and history
### - Calculate goal paces for race times
### - Calculate predicted race times based on their current fitness

![PRLogo](src/main/resources/static/images/PRLogo.png)

## Instructions:

 - Set hibernate ddl to "create" in application.properties
 - Run Schreier_John_PRedictions_CaseStudyApplication as a Spring Boot program
 - Set hibernate ddl to "update" in application.properties
 - Un-comment "spring.sql.init.mode=always" in application properties
 - Let data.sql file populate Coach table in db
 - comment out "spring.sql.init.mode=always" to keep data.sql to keep from loading again.

 **ERD and wireframes folder in root directory**
 
## Technologies Used:

 - Java/JavaScript/CSS/HTML
 - Intellij
 - Spring Data JPA
 - Hibernate
 - MariaDB/HeidiSQL
 - Spring Boot
 - Spring Security
 - Thymeleaf
 - Bootstrap
