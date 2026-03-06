<h1 align="center">☕ Java Advanced Training Workspace</h1>

<p align="center">
  <a href="https://www.java.com"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"></a>
  <img src="https://img.shields.io/badge/JDK-21-blue?style=for-the-badge&logo=openjdk&logoColor=white" alt="JDK 21">
  <img src="https://img.shields.io/badge/IDE-Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white" alt="Eclipse">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" alt="Hibernate">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot">
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

| # | Assignment | Date | Stack | Description |
|:-:|------------|------|-------|-------------|
| 1 | 📦 **Product CRUD** | `10-Feb` | Hibernate · JUnit | Product entity with DAO layer, CRUD ops & test coverage |
| 2 | 🧑‍🤝‍🧑 **Person & Passport** | `11-Feb` | Hibernate · JUnit | One-to-One mapping with separate DAOs & unit tests |
| 3 | 🎓 **Student Hibernate** | `12-Feb` | Hibernate · JUnit | Student entity with DAO pattern & test suite |
| 4a | 🧪 **Mockito Testing** | `13-Feb` | Mockito · JUnit | PriceService mocking, stubbing & verification |
| 4b | 🏠 **Student-Hostel-Aadhar** | `13-Feb` | Hibernate · JUnit | Multi-entity One-to-One mappings (Hostel + Aadhar) |
| 5a | 🏫 **University System** | `14-Feb` | Hibernate · JUnit | Course, Instructor, Enrollment — multi-relationship model |
| 5b | 🏥 **Hospital One-to-Many** | `14-Feb` | Hibernate · JUnit | Doctor → Patient → Appointment → MedicalRecord chain |
| 6 | 📝 **Blog Platform** | `16-Feb` | Hibernate · JUnit | User-Post-Comment system with JPQL queries |
| 7 | 🏥 **Hospital Management ERP** | `21-Feb` | Hibernate · Spring | Full ERP — Department, Doctor, Patient, Appointment, Prescription, MedicalRecord |
| T1 | 📊 **CRM System** | `21-Feb` | Hibernate | Customer, Lead, Order, Product, SalesEmployee, SupportTicket management |
| F1 | 💰 **Fintech Banking** | `23-Feb` | Hibernate | BankAccount, Card, Customer, Transaction — banking CRUD system |
| 7a | 💳 **Payment System (DI)** | `25-Feb` | Spring | Spring DI — Constructor, Field & Qualifier injection with TransactionLogger |
| 7b | 🍔 **Food Delivery (DI)** | `25-Feb` | Spring | Spring DI — Order, Notification, Delivery with Scopes & Lifecycle hooks |
| 7c | 🏦 **Loan Application (DI)** | `25-Feb` | Spring | Spring DI — Loan validation & Audit service with Bean configuration |
| 8 | 🛒 **Product-Category API** | `26-Feb` | Spring Boot | REST API — Product & Category CRUD with Repository & Service layers |
| 9 | 📚 **Library Mgmt System** | `27-Feb` | Spring Boot · Data JPA | Relational mappings (Book, Author, Member, Loan) with DAO pattern |
| 10 | 🔗 **URL Shortener** | `28-Feb` | Spring Boot · OpenAPI | RESTful service with redirection, Swagger UI & JPA persistence |
| 11 | ✅ **TaskTrack Manager** | `05-Mar` | Spring Boot · JSP | To-Do manager with image upload, form validation & professional JSP UI |
| 12 | 📅 **Event Announcement** | `06-Mar` | Spring Boot · Security | Role-based access control (RBAC) for event management & security configs |

---

## � Project Structure

```
Java_Advanced_Training/
│
├── 📝 Assignments
│   ├── 📦 Assignment1(10-Feb-26)/            — Product CRUD (Hibernate + JUnit)
│   ├── 🧑‍🤝‍🧑 Assignment2(11-Feb-26)/            — Person-Passport One-to-One Mapping
│   ├── 🎓 Assignment3(12-Feb-26)/            — Student Hibernate DAO
│   ├── 🧪 Assignment4(13-Feb-26)Mockito/     — Mockito Testing (PriceService)
│   ├── 🏠 Assignment4(13-Feb-26)hibernate/   — Student-Hostel-Aadhar Mapping
│   ├── 🏫 Assignment5(14-Feb-26)University/  — University System (Multi-entity)
│   ├── 🏥 Assignment5(14-Feb-26)oneTomany/   — Hospital One-to-Many
│   ├── 📝 Assignment6(16-Feb-26)/            — Blog Platform (User-Post-Comment)
│   ├── 💳 Assignment7-Task1(25-Feb-26)/      — Spring DI Payment System
│   ├── 🍔 Assignement7-Task2(25-Feb-26)/     — Spring DI Food Delivery System
│   ├── 🏦 Assignment7-Task3(25-Feb-26)/      — Spring DI Loan Application System
│   ├── 🛒 Assignment8-customer-Product-26-Feb/— Spring Boot Product-Category REST API
│   ├── 🏥 HospitalManagement_ERP(21-Feb-26)/ — Hospital ERP (Full Enterprise System)
│   ├── 💰 Fintech_Assignment(23-Feb-26)/     — Fintech Banking CRUD System
│   ├── 📚 Assignment9-27-Feb-Library-System/ — Library Management (Relational Mappings)
│   ├── 🔗 Assignment10(Url-Shortner)28-Feb/  — URL Shortener Service (OpenAPI/Swagger)
│   ├── ✅ Assignment11-TaskTracker-05-03-26/ — TaskTrack To-Do Application (JSP/Validation)
│   └── 📅 Assignment12-Event-Annoucement/    — Event Announcement (Spring Security)
│
├── 📋 Tasks
│   └── 📊 TASK-1-CRM(21-Feb-26)/            — CRM System (Customer, Lead, Order, Sales)
│
├── 📚 Learning Modules — Hibernate Mappings
│   ├── one_to_one_mapping/                   — Car ↔ Engine (Unidirectional)
│   ├── oneToone_mapping_bidirectional/       — Person ↔ Passport (Bidirectional)
│   ├── oneTomany_Mapping/                    — College → Student (Unidirectional)
│   ├── oneTomany_bidirectional/              — College ↔ Student (Bidirectional)
│   ├── manyToone_Mapping/                    — Employee → Department
│   ├── manyTomany_mapping/                   — Student ↔ Subject (Unidirectional)
│   └── manyTomanyBidirectional/              — Student ↔ Subject (Bidirectional)
│
├── 📚 Learning Modules — Core
│   ├── basicsOfJava/                         — Core Java Foundations
│   ├── basicsofJdbc/                         — JDBC Fundamentals
│   ├── learn_jdbc/                           — JDBC Practice & Examples
│   └── cachePraticse/                        — Hibernate Caching Strategies
│
├── 🌿 Spring
│   ├── basics_of_Spring/                     — Spring Framework Basics (DI, Beans)
│   ├── class_level_config_BasicSpring/       — Spring Java-based Configuration
│   ├── spring_Hibernate/                     — Spring + Hibernate Integration (Employee DAO)
│   ├── springmvc/                            — Spring MVC Web Application
│   ├── springmvcboot/                        — Spring Boot MVC + JPA Repository
│   ├── basicsofspringbootmvc/                — Advanced Spring Boot MVC Modules
│   └── springbootbasic/                      — Spring Boot Basics (JPA, REST)
│
├── 🛡️ Spring Security
│   ├── springsecuritydemo/                  — Spring Security Fundamentals (RBAC)
│   ├── springsecuritydbconnection/          — Database Authentication & AuthZ
│   └── cors/                                 — Cross-Origin Resource Sharing Config
│
├── 📚 Learning Modules — Testing
│   ├── Junit_Testing/                        — JUnit 5 Test Suites
│   ├── MockitoPractice/                      — Mockito Mocking & Stubbing
│   └── mockitotest/                          — Mockito UserService Tests
│
├── 📚 Learning Modules — Enterprise
│   ├── com.capgemini/                        — JDBC Enterprise CRUD Operations
│   ├── hibernate_basics/                     — Hibernate ORM Introduction
│   └── product_hibernate/                    — Advanced Hibernate DAO Patterns
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
| **Spring Framework** | Bean Configuration (XML & Java-based), Dependency Injection, Component Scanning, Qualifier, Scopes, Lifecycle Hooks, Spring MVC |
| **Spring Boot** | REST Controllers, JPA Repositories, OpenAPI/Swagger, Derived Query Methods, Exception Handling |
| **Testing** | JUnit 5 (Assertions, Lifecycle Hooks), Mockito (Mocking, Stubbing, Verification) |
| **Security** | Authentication, RBAC (Role-Based Access Control), Password Encoding, CORS Config |
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
