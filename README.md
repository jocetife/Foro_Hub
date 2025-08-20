# ForoHub API

Welcome! This project is a solution to the **Forum Challenge** from the **Oracle ONE + Alura LATAM** program, part of the course **“Java and Spring Boot”**. The goal is to put into practice everything learned so far by creating a **RESTful API for a forum**.

The application allows users to **create, read, update, and delete** discussion topics. To ensure security, it implements **JWT (JSON Web Token) authentication**, so only authenticated users can create or modify forum content.

---

## 💡 Project Overview

Imagine building your own forum — a space where users can post questions or suggestions and interact within a community. While this is a **backend-only** application (no front-end), it’s fully testable using tools like **Insomnia** or **Postman**.

### What you can do with the API:

#### ✅ List Topics  
`GET /topicos`  
Returns a list of all registered topics.

#### 🆕 Create a Topic  
`POST /topicos`  
Requires authentication (Bearer token). Includes fields like `title`, `message`, `author`, and `course`.

#### ✏️ Update a Topic  
`PUT /topicos/{id}`  
Allows editing an existing topic. Requires authentication.

#### ❌ Delete a Topic  
`DELETE /topicos/{id}`  
Deletes a topic by ID. Requires authentication.

#### 🔐 Authenticate User  
`POST /login`  
Receives credentials and returns a **JWT** that must be used in subsequent requests as a **Bearer Token**.

<img width="530" height="438" alt="image" src="https://github.com/user-attachments/assets/ddb7fa98-f41f-489d-9702-69e24b4a72b8" />

<img width="179" height="203" alt="image" src="https://github.com/user-attachments/assets/60c586ab-d404-49e4-a317-520b9a310088" />

---

## 🛡️ Authentication Flow

1. Send a `POST` request to `/login` with email and password.
2. Receive a **Bearer Token** in the response.
3. Use this token in the `Authorization` header of other requests

## 🎯 Learning Outcomes

- By completing this project, participants will gain experience in:
- Java programming and OOP principles – applying object-oriented design in a real-world backend application.
- Working with APIs and handling JSON data – sending requests, parsing responses, and integrating with a RESTful API.
- Using Spring Boot and Spring Data JPA – building a full-featured backend with security, persistence, and migrations.
- Managing projects with agile tools like Trello – organizing tasks, breaking down features, and tracking progress.
- Practicing database operations and ensuring data integrity – performing CRUD operations while avoiding duplicate entries and maintaining consistent data.
