# Java Advanced Workspace

This workspace contains a collection of Java projects focused on advanced concepts, including JDBC, Hibernate ORM, and JUnit testing. It serves as a comprehensive repository for learning and practicing database connectivity and object-relational mapping in Java.

## Projects Overview

### 1. [com.capgemini](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/com.capgemini)
- **Description**: Focused on basic JDBC operations and CRUD functionality.
- **Key Concepts**: Database connectivity, `Employee` management, and JDBC templates.
- **Technologies**: Java, Maven, PostgreSQL, JUnit 5.

### 2. [hibernate_basics](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/hibernate_basics)
- **Description**: An introduction to Hibernate ORM, covering basic configurations and entity mappings.
- **Key Concepts**: Hibernate sessions, transaction management, and basic entity structures for `Product`, `Student`, and `Employee`.
- **Technologies**: Java, Maven, Hibernate 5, PostgreSQL.

### 3. [product_hibernate](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/product_hibernate)
- **Description**: Advanced Hibernate project demonstrating complex mappings and DAO (Data Access Object) patterns.
- **Key Concepts**: One-to-One mappings (e.g., `Person` to `Passport`), DAO implementations, and service-layer separation.
- **Technologies**: Java, Maven, Hibernate 5, PostgreSQL.

### 4. [Junit_Testing](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/Junit_Testing)
- **Description**: Dedicated to unit testing practices.
- **Key Concepts**: Writing robust test cases for application logic using JUnit 5 assertions and lifecycle hooks.
- **Technologies**: Java, Maven, JUnit 5.

### 5. Supplemental Learning Projects
- **[basicsOfJava](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/basicsOfJava)**: Core Java foundational exercises.
- **[basicsofJdbc](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/basicsofJdbc)**: Early explorations into JDBC.
- **[learn_jdbc](file:///c:/Users/Naman%20Prakash/eclipseADV-workspace/learn_jdbc)**: Additional JDBC practice and examples.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven**: For dependency management.
- **PostgreSQL**: The database engine used across most projects. Ensure a local or remote instance is running.

## Setup and Running

1. **Database Setup**:
   - Create a PostgreSQL database (typically named in the `hibernate.cfg.xml` or JDBC connection strings).
   - Configure your database credentials in the respective project configuration files.

2. **Importing Projects**:
   - These are Maven projects. Import them into your IDE (Eclipse, IntelliJ IDEA, etc.) as "Existing Maven Projects".

3. **Running Tests**:
   - Use `mvn test` to run JUnit test suites across the projects.

4. **Running Main Methods**:
   - Many projects include a `Main` or `Dao` class with a `public static void main` method to demonstrate functionality directly.
