# NetBeans Projects

This repository contains a collection of NetBeans projects. Currently, it features two distinct projects: a basic calculator application (`Calc`) and a database connection utility (`DB_Connection`).  Additionally, an "EAD" (Enterprise Application Development) project is included, which appears to be a hotel management system.  A game project is also present, showing an initial attempt at 2D animation.

## Table of Contents

- [Projects Overview](#projects-overview)
- [Calc Project](#calc-project)
  - [Features](#calc-features)
  - [Technology Stack](#calc-technology-stack)
  - [Prerequisites](#calc-prerequisites)
  - [Installation](#calc-installation)
  - [Usage](#calc-usage)
- [DB_Connection Project](#db_connection-project)
  - [Features](#db_connection-features)
  - [Technology Stack](#db_connection-technology-stack)
  - [Prerequisites](#db_connection-prerequisites)
  - [Configuration](#db_connection-configuration)
  - [Usage](#db_connection-usage)
- [EAD Project](#ead-project)
  - [Features](#ead-features)
  - [Technology Stack](#ead-technology-stack)
  - [Prerequisites](#ead-prerequisites)
  - [Configuration](#ead-configuration)
  - [Usage](#ead-usage)
- [game Project](#game-project)
  - [Features](#game-features)
  - [Technology Stack](#game-technology-stack)
  - [Prerequisites](#game-prerequisites)
  - [Usage](#game-usage)
- [License](#license)
- [Contact](#contact)

## Projects Overview

This repository showcases a range of Java projects created using NetBeans IDE. These projects vary in complexity, from a simple calculator to a more elaborate enterprise application and a rudimentary game.

## Calc Project

The `Calc` project implements a basic GUI-based calculator using Java AWT.

### Features

*   Basic arithmetic operations (+, -, \*, /)
*   Square root calculation
*   Calculation history
*   Undecorated Frame

### Technology Stack

*   Java AWT

### Prerequisites

*   Java Development Kit (JDK) 15 or later. (Based on Javadoc, project was compiled with JDK 15)

### Installation

1.  Clone the repository:

    ```bash
    git clone https://github.com/billodi/NetBeansProjects.git
    ```

2.  Open the `Calc` project in NetBeans.

### Usage

1.  Run the `GUI.calf.java` file.
2.  Use the buttons on the calculator to perform calculations.
3.  The calculation history can be viewed by pressing the "H" button.

## DB_Connection Project

This project provides a utility class for establishing a database connection to a MySQL database.

### Features

*   Establishes a connection to a MySQL database.
*   Provides methods for executing INSERT, UPDATE, and DELETE (IUD) queries.
*   Provides a method for executing SELECT queries and retrieving results.

### Technology Stack

*   Java
*   JDBC
*   MySQL

### Prerequisites

*   MySQL Server installed and running.
*   MySQL Connector/J JDBC driver.

### Configuration

1.  Add the MySQL Connector/J JDBC driver to the project's classpath in NetBeans.
2.  Modify the connection details in `DB_Connection/src/DBMS/dbms.java` to match your database configuration:

    ```java
    String url = "jdbc:mysql://localhost:3306/";
    String un = "root";
    String pw = "";
    c = DriverManager.getConnection(url+"DatabaseName"+"?useSSL=false",un,pw);
    ```

    *   Replace `"DatabaseName"` with the name of your database.
    *   Set the username (`un`) and password (`pw`) accordingly.

### Usage

1.  Import the `DBMS` package into your Java code.
2.  Use the `dbms.iud()` method to execute INSERT, UPDATE, or DELETE queries:

    ```java
    try {
        DBMS.iud("INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')");
    } catch (Exception e) {
        e.printStackTrace();
    }
    ```

3.  Use the `dbms.search()` method to execute SELECT queries:

    ```java
    try {
        ResultSet rs = DBMS.search("SELECT * FROM your_table");
        while (rs.next()) {
            // Process the result set
            System.out.println(rs.getString("column1"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    ```

## EAD Project

The `EAD` project is an Enterprise Application Development project that implements a hotel management system.

### Features

*   User authentication (Login and Registration for Staff)
*   Admin Access
*   Customer Information Management (Add, Update, Delete, Search)
*   Room Booking
*   Food Order Management
*   Payment Bill Generation

### Technology Stack

*   Java
*   Swing (GUI)
*   JDBC (Database Connectivity)
*   com.toedter.calendar
*   org.jdesktop.swingx
*   Netbeans IDE (For UI design assistance)
*   Jasper Reports

### Prerequisites

*   Java Development Kit (JDK 8 or later)
*   MySQL database server
*   JasperReports library
*   toedter Calendar library
*   swingx library

### Configuration

1.  Ensure that the required libraries (JasperReports, toedter Calendar, and Swingx) are included in the project's classpath within NetBeans.
2.  Update database connection string in `src/model/DBM.java`:
```java
 Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:hms.db");
```

### Usage

1. Run `PreLogin.java` to set up admin credential.
2. Run the `Login.java` class to start the application.
3. Use the GUI to manage customer information, bookings, food orders, and payments.

## game Project

An early attempt at making a simple 2D game with character animation.

### Features

*   2D character animation (idle, run, jump, attack)
*   Key press movement (right/left)
*   Basic sprite scaling

### Technology Stack

*   Java Swing

### Prerequisites

*   Java Development Kit (JDK)
*   An IDE that supports Java Swing projects (like NetBeans or IntelliJ IDEA)

### Usage

1.  Open the project in NetBeans or your preferred IDE.
2.  Run the `GUI.Test1.java` or `GUI/testmanual.java` file.
3.  Press the 'h' and 'j' keys for animations. Arrow keys provide movement.

## License

No license specified. All rights reserved by the repository owner.

## Contact

[https://github.com/billodi/NetBeansProjects](https://github.com/billodi/NetBeansProjects)
