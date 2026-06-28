# 🔐 UserAuthSystem



A desktop user authentication and management system developed with **Java 20**, **Jakarta Persistence (JPA)**, **Hibernate**, **HikariCP**, and **MySQL**. The application follows the **MVC architectural pattern**, demonstrating layered software design, user authentication, role-based access control, CRUD operations, and efficient database connectivity through connection pooling.



---



## ✨ Features



- 🏛 **MVC Architecture** – Clear separation between Presentation (Swing), Business Logic, and Persistence layers.

- 🔑 **User Authentication** – Login and registration system with input validation.

- 👥 **Role-Based Access Control** – Supports Administrator and Standard User roles.

- 📋 **User Management (CRUD)** – Full Create, Read, Update, and Delete operations.

- 🚫 **Duplicate Username Validation** – Prevents duplicate usernames before persistence.

- ⚡ **Connection Pooling** – Uses **HikariCP** to efficiently manage database connections and reduce connection creation overhead.

- 💾 **JPA Persistence** – Database interaction implemented using **Jakarta Persistence (JPA)** with **Hibernate 6.x** as the ORM provider.

- 🖥 **Desktop GUI** – User-friendly Java Swing interface with standardized dialogs and intuitive navigation.

- 🛡 **Error Handling** – Structured exception handling and input validation across all application layers.



---



## 🏗 Architecture



```text

Presentation Layer (Swing)

          │

          ▼

Business Logic (Controller)

          │

          ▼

Persistence Layer (JPA + Hibernate)

          │

          ▼

HikariCP Connection Pool

          │

          ▼

MySQL Database

```



---



## 🛠 Tech Stack



| Technology | Description |

|------------|-------------|

| Java 20 | Programming Language |

| Java Swing | Desktop User Interface |

| Jakarta Persistence (JPA) 3.0 | ORM Specification |

| Hibernate 6.x | JPA Implementation |

| HikariCP | Database Connection Pool |

| MySQL 8 | Relational Database |

| Maven | Dependency Management |



---



## 📂 Project Structure



```text

src/

└── com.login/

    ├── igu/            # Swing user interface

    ├── logic/          # Business logic, entities, and controllers

    ├── persistence/    # JPA controllers and persistence layer

    └── Main.java       # Application entry point

```



---



## 🚀 Getting Started



### Prerequisites



- Java 20 or higher

- MySQL Server

- Maven



### Database Setup



Create the database:



```sql

CREATE DATABASE login;

```



Configure the database connection properties in **persistence.xml** (including the HikariCP configuration).



Run the **Main** class to start the application.



---



## 📱 Core Functionalities



### 🔐 Authentication



- User login.

- User registration.

- Input validation.

- Duplicate username validation.



### 👤 User Administration



- Create new users.

- Edit existing users.

- Delete users.

- Manage user roles.

- Confirmation dialogs for sensitive operations.



### ⚡ Database Management



- Efficient database connection pooling with HikariCP.

- Persistence using Jakarta Persistence (JPA) and Hibernate.

- Transaction management through JPA.



---



## 🎯 Learning Outcomes



This project allowed me to:



- Apply the MVC architectural pattern in a desktop application.

- Implement CRUD operations using Jakarta Persistence (JPA).

- Configure Hibernate as the JPA provider.

- Integrate HikariCP for efficient database connection management.

- Improve exception handling and input validation.

- Develop a maintainable multi-layer Java application.
