<h1>Java Advanced Workspace</h1>


  <a href="https://www.java.com"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"></a>
  <img src="https://img.shields.io/badge/JDK-21-blue?style=for-the-badge&logo=openjdk&logoColor=white" alt="JDK 21">
  <img src="https://img.shields.io/badge/IDE-Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white" alt="Eclipse">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit">
  <img src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge" alt="Active">

This workspace contains a collection of Java projects focused on advanced concepts, including JDBC, Hibernate ORM, and JUnit testing. It serves as a comprehensive repository for learning and practicing database connectivity and object-relational mapping in Java.

📂 Project Structure

```
Advanced_Java_Training/
│
├── 📁 Junit_Testing/
├── 📁 basicsOfJava/
├── 📁 basicsofJdbc/
├── 📁 com.capgemini/
├── 📁 hibernate_basics/
├── 📁 learn_jdbc/
└── 📁 product_hibernate/
```

📋 Projects Overview

🏢 1. com.capgemini
> Enterprise JDBC Operations & CRUD Functionality

- Description: Focused on basic JDBC operations and CRUD functionality.
- Key Concepts: Database connectivity, Employee management, and JDBC templates.
- Tech Stack: Java • Maven • PostgreSQL • JUnit 5

---

❄️ 2. hibernate_basics
> Introduction to Hibernate ORM

- Description: An introduction to Hibernate ORM, covering basic configurations and entity mappings.
- Key Concepts: Hibernate sessions, transaction management, and basic entity structures for Product, Student, and Employee.
- Tech Stack: Java • Maven • Hibernate 5 • PostgreSQL

---

🔧 3. product_hibernate
> Advanced Hibernate with DAO Patterns

- Description: Advanced Hibernate project demonstrating complex mappings and DAO (Data Access Object) patterns.
- Key Concepts: One-to-One mappings (e.g., Person to Passport), DAO implementations, and service-layer separation.
- Tech Stack: Java • Maven • Hibernate 5 • PostgreSQL

---

🧪 4. Junit_Testing
> Unit Testing Best Practices

- Description: Dedicated to unit testing practices.
- Key Concepts: Writing robust test cases for application logic using JUnit 5 assertions and lifecycle hooks.
- Tech Stack: Java • Maven • JUnit 5

---

📚 5. Supplemental Learning Projects
- basicsOfJava: Core Java foundational exercises
- basicsofJdbc: Early explorations into JDBC
- learn_jdbc: Additional JDBC practice and examples

---

⚙️ Prerequisites

| Requirement | Version | Description |
|------------|---------|-------------|
| ☕ Java JDK | 8 or higher | Java Development Kit |
| 📦 Maven | Latest | Dependency management and build tool |
| 🗄️ PostgreSQL | Latest | Database engine for all projects |

---

🚀 Getting Started

1️⃣ Database Setup
```bash
Create a PostgreSQL database
Configure credentials in hibernate.cfg.xml or JDBC connection strings
```
- Create a PostgreSQL database (typically named in the configuration files)
- Configure your database credentials in the respective project configuration files

2️⃣ Import Projects
```bash
Import as Maven projects in your IDE
Eclipse: File → Import → Existing Maven Projects
```
- These are Maven projects
- Import them into your IDE (Eclipse, IntelliJ IDEA, etc.) as "Existing Maven Projects"

3️⃣ Run Tests
```bash
mvn test
```
- Use mvn test to run JUnit test suites across the projects

4️⃣ Execute Main Methods
- Many projects include a Main or Dao class with a public static void main method
- Run these directly to demonstrate functionality


<div align="center">
  <sub><h4>Built with ❤️ using Java, Hibernate, and PostgreSQL</h4></sub>
</div>
