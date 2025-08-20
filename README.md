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

---

## 🛡️ Authentication Flow

1. Send a `POST` request to `/login` with email and password.
2. Receive a **Bearer Token** in the response.
3. Use this token in the `Authorization` header of other requests
