<h1 align="center">☕ Java Advanced Training Workspace</h1>

<p align="center">
  <a href="https://www.java.com"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"></a>
  <img src="https://img.shields.io/badge/JDK-21-blue?style=for-the-badge&logo=openjdk&logoColor=white" alt="JDK 21">
  <img src="https://img.shields.io/badge/IDE-Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white" alt="Eclipse">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" alt="Hibernate">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring">
  <img src="https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit">
  <img src="https://img.shields.io/badge/Mockito-78A641?style=for-the-badge" alt="Mockito">
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge" alt="Active">
</p>

<p align="center">
  <em>A comprehensive repository of Java projects covering advanced concepts — JDBC, Hibernate ORM, Spring Framework, JUnit & Mockito testing, and enterprise-grade application design. Built as part of QSpiders Advanced Java Training.</em>
</p>

---

## 📝 Assignments

<table>
<tr>
<td width="50%">

### 📦 Assignment 1 — Product CRUD
**`10-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Hibernate-based **Product** entity with full DAO layer and JUnit test coverage. Demonstrates `@Entity`, `@Id`, CRUD operations, and EntityManager lifecycle.

<sub>📂 `Assignment1(10-Feb-26)/`</sub>

</td>
<td width="50%">

### 🧑‍🤝‍🧑 Assignment 2 — Person & Passport (One-to-One)
**`11-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

One-to-One mapping between **Person** and **Passport** entities with separate DAO layers and unit tests for both entities.

<sub>📂 `Assignment2(11-Feb-26)/`</sub>

</td>
</tr>

<tr>
<td width="50%">

### 🎓 Assignment 3 — Student Hibernate
**`12-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Student entity with Hibernate DAO pattern. Includes **StudentDao** for persistence operations and corresponding test suite.

<sub>📂 `Assignment3(12-Feb-26)/`</sub>

</td>
<td width="50%">

### 🧪 Assignment 4a — Mockito Testing
**`13-Feb-2026`** &nbsp; &nbsp; ![Mockito](https://img.shields.io/badge/Mockito-78A641?style=flat-square) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Mockito-based test suite for a **PriceService** that depends on a **DiscountRepo**. Demonstrates mocking, stubbing, and verification of service-layer logic.

<sub>📂 `Assignment4(13-Feb-26)Mockito/`</sub>

</td>
</tr>

<tr>
<td width="50%">

### 🏠 Assignment 4b — Student-Hostel-Aadhar Mapping
**`13-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Multi-entity Hibernate project: **Studentuser ↔ HostelRoom** (One-to-One) and **Studentuser ↔ AadharCard** (One-to-One) mappings with test verification.

<sub>📂 `Assignment4(13-Feb-26)hibernate/`</sub>

</td>
<td width="50%">

### 🏫 Assignment 5a — University System
**`14-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Full university domain model: **Course**, **Instructor**, **InstructorProfile**, and **Enrollment** entities. Implements One-to-One, One-to-Many, and service-layer patterns with a **UniversityService** and DAO classes.

<sub>📂 `Assignment5(14-Feb-26)University/`</sub>

</td>
</tr>

<tr>
<td width="50%">

### 🏥 Assignment 5b — Hospital One-to-Many
**`14-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Hospital domain with **Doctor → Patient → Appointment → MedicalRecord** relationships. Demonstrates One-to-Many and Many-to-One mappings with DAO layer and test coverage.

<sub>📂 `Assignment5(14-Feb-26)oneTomany/`</sub>

</td>
<td width="50%">

### 📝 Assignment 6 — Blog Platform
**`16-Feb-2026`** &nbsp; &nbsp; ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white) ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white)

Complete blogging platform: **User**, **Post**, and **Comment** entities. Full **BlogService** with user registration, post CRUD, commenting, and JPQL queries for fetching posts/comments by user or post.

<sub>📂 `Assignment6(16-Feb-26)/`</sub>

</td>
</tr>
</table>

---

## 🚀 Major Projects

### 🏥 Hospital Management ERP &nbsp; `21-Feb-2026`
> Enterprise-grade Hospital ERP system

Full-featured hospital management system with **Department**, **Doctor**, **Patient**, **Appointment**, **MedicalRecord**, and **Prescription** entities. Each entity has its own dedicated service class. Demonstrates complex Many-to-Many and One-to-Many relationships in a real-world domain.

**Tech Stack:** Java • Hibernate • PostgreSQL

<sub>📂 `HospitalManagement_ERP(21-Feb-26)/`</sub>

---

### 💼 CRM System (Task-1) &nbsp; `21-Feb-2026`
> Customer Relationship Management Application

Full CRM system with **Customer**, **Lead**, **SalesEmployee**, **Product**, **Order**, **SupportTicket**, and **Address** entities. Includes services for lead management, order processing, product catalogue, ticket handling, and report generation via **ReportService**.

**Tech Stack:** Java • Hibernate • PostgreSQL

<sub>📂 `TASK-1-CRM(21-Feb-26)/`</sub>

---

## � Project Structure

```
Java_Advanced_Training/
│
├── 📝 Assignments
│   ├── 📦 Assignment1(10-Feb-26)/          — Product CRUD (Hibernate + JUnit)
│   ├── 🧑‍🤝‍🧑 Assignment2(11-Feb-26)/          — Person-Passport One-to-One Mapping
│   ├── 🎓 Assignment3(12-Feb-26)/          — Student Hibernate DAO
│   ├── 🧪 Assignment4(13-Feb-26)Mockito/   — Mockito Testing (PriceService)
│   ├── 🏠 Assignment4(13-Feb-26)hibernate/ — Student-Hostel-Aadhar Mapping
│   ├── 🏫 Assignment5(14-Feb-26)University/ — University System (Multi-entity)
│   ├── 🏥 Assignment5(14-Feb-26)oneTomany/ — Hospital One-to-Many
│   └── 📝 Assignment6(16-Feb-26)/          — Blog Platform (User-Post-Comment)
│
├── 🚀 Major Projects
│   ├── 🏥 HospitalManagement_ERP(21-Feb-26)/ — Hospital ERP System
│   └── 💼 TASK-1-CRM(21-Feb-26)/             — CRM Application
│
├── 📚 Learning Modules — Hibernate Mappings
│   ├── one_to_one_mapping/                 — Car ↔ Engine (Unidirectional)
│   ├── oneToone_mapping_bidirectional/     — Person ↔ Passport (Bidirectional)
│   ├── oneTomany_Mapping/                  — College → Student (Unidirectional)
│   ├── oneTomany_bidirectional/            — College ↔ Student (Bidirectional)
│   ├── manyToone_Mapping/                  — Employee → Department
│   ├── manyTomany_mapping/                 — Student ↔ Subject (Unidirectional)
│   └── manyTomanyBidirectional/            — Student ↔ Subject (Bidirectional)
│
├── 📚 Learning Modules — Core & Frameworks
│   ├── basicsOfJava/                       — Core Java Foundations
│   ├── basicsofJdbc/                       — JDBC Fundamentals
│   ├── learn_jdbc/                         — JDBC Practice & Examples
│   ├── basics_of_Spring/                   — Spring Framework Basics
│   ├── class_level_config_BasicSpring/     — Spring Java-based Configuration
│   └── cachePraticse/                      — Hibernate Caching Strategies
│
├── 📚 Learning Modules — Testing
│   ├── Junit_Testing/                      — JUnit 5 Test Suites
│   ├── MockitoPractice/                    — Mockito Mocking & Stubbing
│   └── mockitotest/                        — Mockito UserService Tests
│
├── 📚 Learning Modules — Enterprise
│   ├── com.capgemini/                      — JDBC Enterprise CRUD Operations
│   ├── hibernate_basics/                   — Hibernate ORM Introduction
│   └── product_hibernate/                  — Advanced Hibernate DAO Patterns
│
└── README.md
```

---

## 🔧 Topics & Concepts Covered

| Area | Concepts |
|------|----------|
| **Hibernate ORM** | Entity Mapping, Session/EntityManager, Transactions, HQL/JPQL Queries, Caching |
| **Relationship Mappings** | One-to-One (Uni & Bi), One-to-Many (Uni & Bi), Many-to-One, Many-to-Many (Uni & Bi) |
| **JDBC** | DriverManager, PreparedStatement, ResultSet, Connection Pooling |
| **Spring Framework** | Bean Configuration (XML & Java-based), Dependency Injection, Component Scanning |
| **Testing** | JUnit 5 (Assertions, Lifecycle Hooks), Mockito (Mocking, Stubbing, Verification) |
| **Design Patterns** | DAO Pattern, Service Layer, Entity Relationships, Configuration Management |

---

## ⚙️ Prerequisites

| Requirement | Version | Description |
|------------|---------|-------------|
| ☕ Java JDK | 21 or higher | Java Development Kit |
| 📦 Maven | Latest | Dependency management and build tool |
| 🗄️ PostgreSQL | Latest | Database engine for all projects |
| 🖥️ Eclipse IDE | Latest | Recommended IDE |

---

## 🚀 Getting Started

**1️⃣ &nbsp; Database Setup**
```bash
# Create a PostgreSQL database (name as specified in hibernate.cfg.xml or persistence.xml)
# Configure credentials in the respective project configuration files
```

**2️⃣ &nbsp; Import Projects**
```bash
# Eclipse: File → Import → Existing Maven Projects → Select project folder
# IntelliJ: File → Open → Select project folder (auto-detects Maven)
```

**3️⃣ &nbsp; Run Tests**
```bash
mvn test
```

**4️⃣ &nbsp; Execute Main Methods**
- Most projects include a `Main` or `Dao` class with a `public static void main` method
- Run these directly to demonstrate functionality

---

<div align="center">
  <sub><h3>Built with ❤️ using Java, Hibernate, Spring & PostgreSQL</h3></sub>
  <sub>QSpiders Advanced Java Backend Training • 2026</sub>
</div>
