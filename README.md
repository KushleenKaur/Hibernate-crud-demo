# Hibernate CRUD Demo Application

This is a simple Java application that demonstrates CRUD (Create, Read, Update, Delete) operations using Hibernate ORM with a MySQL database.

## Project Overview

The application manages Student entities with the following operations:
- Create: Add new students to the database
- Read: Retrieve student information by ID or get all students
- Update: Modify existing student details
- Delete: Remove students from the database

## Prerequisites

- Java 11
- MySQL Server
- Maven

## Setup Instructions

### 1. Database Setup

1. Install MySQL if you haven't already
2. Run the SQL script located at `src/main/resources/database_setup.sql` to create the database and table:

```bash
mysql -u root -p < src/main/resources/database_setup.sql
```

### 2. Configure Database Connection

Update the database connection details in `src/main/resources/hibernate.cfg.xml` if needed:

```xml
<property name="connection.url">jdbc:mysql://localhost:3306/student_tracker?useSSL=false&amp;serverTimezone=UTC</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>
```

### 3. Build the Project

```bash
mvn clean package
```

### 4. Run the Application

```bash
java -cp target/hibernate-crud-demo-1.0-SNAPSHOT.jar com.example.app.StudentCRUDDemo
```

## Project Structure

- `src/main/java/com/example/entity/Student.java` - Student entity class with Hibernate annotations
- `src/main/java/com/example/util/HibernateUtil.java` - Utility class for SessionFactory management
- `src/main/java/com/example/dao/StudentDAO.java` - Data Access Object with CRUD operations
- `src/main/java/com/example/app/StudentCRUDDemo.java` - Main application demonstrating all operations
- `src/main/resources/hibernate.cfg.xml` - Hibernate configuration file
- `src/main/resources/database_setup.sql` - SQL script for database setup

## Key Concepts Demonstrated

1. Entity mapping with Hibernate annotations
2. SessionFactory configuration and management
3. Transaction handling
4. CRUD operations using Hibernate Session API
5. HQL (Hibernate Query Language) for retrieving data