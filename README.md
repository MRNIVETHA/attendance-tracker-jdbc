# Attendance Tracker - Java JDBC Console App

A simple console-based Java application to manage employee attendance, built using JDBC for database operations.

## 📌 Features

- ➕ Add new employees
- 📅 Mark attendance (Present/Absent)
- 📊 View employee attendance report
- 🗃️ MySQL database integration via JDBC

## 🛠️ Tech Stack

- Java 17+
- JDBC
- MySQL
- Eclipse IDE

## 🧠 Concepts Used

- Core Java (OOPs, Collections, Exception Handling)
- JDBC (Connection, Statement, PreparedStatement)
- SQL (CRUD operations)
- Layered architecture (Model, DAO, Service, Main)

## 📂 Project Structure

```
attendance-tracker-jdbc/
├── attendance/
│   ├── DBConnection.java
│   ├── Employee.java
│   ├── EmployeeDAO.java
│   ├── EmployeeService.java
│   └── MainApp.java
└── README.md
```

## 🗄️ Database Setup

1. Create a MySQL database:

```sql
CREATE DATABASE attendance_db;
USE attendance_db;

CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100)
);

CREATE TABLE attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  employee_id INT,
  date DATE,
  status VARCHAR(10),
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);
```

2. Update your DB credentials in `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/attendance_db";
String username = "your_username";
String password = "your_password";
```

## 🚀 How to Run

1. Clone the repo
2. Import into Eclipse
3. Run `MainApp.java` as Java Application
4. Follow the menu in the console

## ✨ Author

👩‍💻 Nivetha MR  
📫 [nivi200111@gmail.com]

---

## ✅ License

This project is open-source for learning purposes.
