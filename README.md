# Technical Quiz App
# Project Description
This Quiz Application is a full-fledged backend system built using Spring Boot, Spring Data JPA, and MySQL that allows users to take quizzes, submit answers, and receive results instantly. It demonstrates end-to-end backend development — from entity design and database relationships to RESTful API creation and JSON-based client-server interaction.

# Features
Question Controller :  As from examiner point of view he/she can view,create,add and delete questions to test the candidate knowledge(CRUD Operations)

Quiz Controller : Examiner have the access to create quiz based on category,how many number of questions should be displayed for each category and aclculate result when the candidate submit the quiz

QuestionService : It implements all the CRUD operations related to Question

QuizService : It implements the methods of creating quiz,getting questions for the created quiz and calculating the results

Repository Clases : It contains the query for getting random questions by category

DTO Class : It contains the getters and setters for connecting between service and controller layer

Entity Class : Database table mappings is done for Question,Quiz and Response entity classes

# Technologies Used
Java 17

Spring Boot

Spring Data JPA (Hibernate)

MySQL

Lombok

Validation API (Jakarta Validation)

Jackson

Postman for API testing

# Project Layers Overview
Entity: Represents database tables.

DTO: Data Transfer Objects for API responses.

Request: Classes for incoming API data.

Service: Business logic layer.

Repository (DAO): Database access layer.

Controller: REST API endpoints.




