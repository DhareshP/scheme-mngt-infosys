
# Scheme Management Module - Policy Management System

This repository contains the **Scheme Management Module** developed as part of an internship project at **Infosys**. The project is a submodule of a larger **Policy Management System** involving four teams working on:

- User and Admin Login
- Scheme Management ✅
- Policy Management
- Feedback & Payment Management

Our team was responsible for designing and implementing the **Scheme Management** functionality, including CRUD operations for schemes and user-scheme mappings.

## 🔧 Technologies Used

- **Java**, **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf** (for frontend templates - separate project)
- **MySQL** (for persistent storage)
- **Maven**
- **RESTful APIs**

---

## 📂 Module Structure

### 1. Scheme Management

Each **Scheme** contains multiple **Policies**. The scheme module provides complete management features such as:

- Create, Update, View Schemes
- Enable/Disable Active Status
- Search by Name
- Fetch Active Schemes

#### `SchemeController.java`

Exposes REST endpoints for scheme operations:

```java
GET     /api/schemes                     // Fetch all schemes
GET     /api/schemes/{id}               // Fetch scheme by ID
POST    /api/schemes                    // Create a new scheme
PUT     /api/schemes/{id}               // Update scheme
PUT     /api/schemes/{id}/status        // Toggle active status
GET     /api/schemes/active             // Fetch active schemes
GET     /api/schemes/search?name=...    // Search by scheme name
```

### 2. User-Scheme Mapping

This allows users to apply to schemes and view their applied schemes.

#### `UserSchemesController.java`

Key features include:

```java
POST    /api/user-schemes/apply?id=...&userId=...     // User applies for a scheme
GET     /api/user-schemes/user/{userId}               // View user's applied schemes
GET     /api/user-schemes/active-schemes              // View all active schemes
GET     /api/user-schemes                             // Admin view: All user-scheme records
```

---

## 🧠 Backend Highlights

- **Email Notification**: Integrated `JavaMailSender` to send email alerts to users when a scheme is successfully bought. This ensures real-time acknowledgment and enhances user engagement.

- **Custom JPA Queries**: Used for optimized search and filtering.
- **Service Layer Architecture**: Ensures business logic is cleanly separated from controllers.
- **Validation & Exception Handling**: Built-in input validation using `@Valid` and custom exceptions (`InvalidEntityException`).

---

## 📸 Sample Thymeleaf Pages (in separate frontend project)

- Scheme Listing Page
- Scheme Application Page
- Scheme Search Feature
- Admin Scheme Management Dashboard

---

## 🗃️ Database

**MySQL** is used to persist scheme and user mapping data. Tables include:

- `schemes`
- `user_schemes`
- (Referential mapping via foreign keys)

---

## ✅ Features Summary

| Feature | Status |
|--------|--------|
| Add, View, Update, Delete Schemes | ✅ |
| Enable/Disable Schemes | ✅ |
| Search Schemes by Name | ✅ |
| User can apply to schemes | ✅ |
| View all schemes applied by user | ✅ |
| Fetch all active schemes | ✅ |

---

## 🚀 Running the Project

1. Clone the repository.
2. Set up MySQL database and update `application.properties`.
3. Build and run the Spring Boot app:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. Access backend APIs via `http://localhost:8080/api/schemes` and `http://localhost:8081/api/user-schemes`.

---

