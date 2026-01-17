# 🧑‍💼 Employee Management System  
> A Java-based console application that performs CRUD (Create, Read, Update, Delete) operations on employee data using Hibernate ORM and MySQL Database.

---

## 🚀 Project Overview

This **Employee Management System** is a simple and modular Java console-based project that allows users to manage employee records effectively.  
It demonstrates key Java and Hibernate concepts such as:
- Object-Oriented Programming (OOP)
- Hibernate ORM for database mapping
- Programmatic configuration (without XML)
- CRUD operations
- SessionFactory and Transactions

---

## 🧩 Features

✅ Add (Insert) multiple Employee records  
✅ Retrieve (Display) employee details  
✅ Update employee information  
✅ Delete employee records  
✅ View all employee details  
✅ Hibernate auto table creation (`hbm2ddl.auto=update`)  
✅ Console-based interactive menu  

---

## 🏗️ Project Structure
Employee-Management-System/
│
├── 📁 src/
│   ├── 📁 com/
│   │   └── 📁 app/
│   │       ├── 📁 client/
│   │       │   └── CURDEmpOpration.java        # Main console class (menu + CRUD methods)
│   │       │
│   │       ├── 📁 model/
│   │       │   ├── Employee.java               # Entity class mapped to MySQL table
│   │       │   └── StudentA.java               # Example secondary entity
│   │       │
│   │       └── 📁 configuration/ (if used)
│   │           └── HibernateUtil.java          # Hibernate configuration (if moved here)
│   │
│   ├── 📁 hibernateUtil/
│   │   └── HibernateUtil.java                  # Builds SessionFactory & handles Hibernate setup
│   │
│   └── 📁 resources/                           # Optional: external resources
│       └── hibernate.cfg.xml (optional)
│
├── 📁 lib/                                     # Hibernate & MySQL JARs (if not using Maven)
│
├── 📁 database/
│   └── stu.sql                                 # SQL schema / DB backup (optional)
│
├── README.md                                   # Project documentation
├── .gitignore                                  # Git ignore rules
└── pom.xml (if using Maven)                    # Maven dependencies file

