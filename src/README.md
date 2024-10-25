# User Access Management System

## Overview
This is a basic User Access Management system that allows users to sign up, request access to software applications, and managers to approve/reject access requests.

## Features
- User Registration
- User Authentication
- Software Management (Admin Only)
- Access Request (Employee)
- Approval of Requests (Manager)

## Technologies
- Java Servlets
- JSP
- PostgreSQL

## Setup

### Prerequisites
- Apache Tomcat
- PostgreSQL
- Maven

### Installation
1. Clone the repository.
2. Create the PostgreSQL database using the script in `sql/create_tables.sql`.
3. Update the database credentials in the servlet files.
4. Build the project using Maven:
5. Deploy the `.war` file to Tomcat.

### Usage
- Access `http://localhost:8080/UserAccessManagement` in your browser.
- Register, log in, and follow the workflow to request and approve access.

## License
This project is licensed under the MIT License.
