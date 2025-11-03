# Technical Quiz App
# Project Description
This Quiz Application is a full-fledged backend system built using Spring Boot, Spring Data JPA, and MySQL that allows users to take quizzes, submit answers, and receive results instantly. It demonstrates end-to-end backend development — from entity design and database relationships to RESTful API creation and JSON-based client-server interaction.

# Features
Question Controller :  As from examiner point of view he/she can view,create,add and delete questions to test the candidate knowledge(CRUD Operations)

QuizController : Examiner have the access to create quiz based on category,how many number of questions should be displayed for each category and aclculate result when the candidate submit the quiz

QuestionService : It implements all the CRUD operations related to Question

QuizService : It implements the methods of creating quiz,getting questions for the created quiz and calculating the results

Repository Clases : It contains the query for getting random questions by category

DTO Class : It contains the getters and setters for connecting between service and controller layer

Entity Class : Database table mappings is done for Question,Quiz and Response entity classes

# Technologies Used
Java 17 - This project is developed by using Java 17 for enterprise level applications

Spring Boot - Backend framework for building Java-based web applications.

Spring Data JPA (Hibernate) - It helps in performing CRUD operations without writing complex SQL queries

MySQL - Relational database management system for data storage.

Lombok - Reduces boilerplate code by automatically generating commonly used methods like getters, setters, constructors & toString().

Postman for API testing

# Project Layers Overview
Entity: Represents database tables.

DTO: Data Transfer Objects for API responses.

Request: Classes for incoming API data.

Service: Business logic layer.

Repository (DAO): Database access layer.

Controller: Handles http requests and reponse

# Sample API Endpoints
## Questions API Endpoints

| **HTTP Method** | **Endpoint** | **Description** |
|------------------|--------------|-----------------|
| **GET** | `/questions/allQuestions` | Gives the list of all questions |
| **GET** | `/questions/category/{category}` | Gives all questions under specific category |
| **POST** | `/questions/add` | Adds additional questions |
| **PUT** | `/questions/update` | Updates existing questions  |
| **DELETE** | `/questions/delete` | deletes all questions  |

## Questions API Endpoints

| **HTTP Method** | **Endpoint** | **Description** |
|------------------|--------------|-----------------|
| **POST** | `/quiz/create?category=" "&numQ=" "&title=" "` | Creates a quiz based on our specification |
| **GET** | `/quiz/get/{id}` | Gives quizes questions you needed  |
| **POST** | `/questions/add` | Adds additional questions |

# Sample JSON Requests

## get questions
```json
{
  "id": 1,
  "questionTitle": "What is a class in Java?",
  "option1": "A function",
  "option2": "An object",
  "option3": "A data structure",
  "option4": "A loop",
  "rightAnswer": "An object",
  "difficultyLevel": "Easy",
  "category": "java"
}



