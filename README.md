# 🛍️ Retail Management System

A full-stack retail management backend built with **Java**, **Spring Boot**, **MySQL**, and **MongoDB**. Includes a responsive admin dashboard frontend for managing stores, products, inventory, customers, orders, and reviews.

---

## 🚀 Tech Stack

### Backend
- Java 21
- Spring Boot 3.5
- Spring Data JPA (Hibernate)
- Spring Data MongoDB
- Spring Validation
- MySQL 8
- MongoDB
- Maven

### Frontend
- HTML5 / CSS3 / Vanilla JavaScript
- Served as a static file via Spring Boot

---

## ✨ Features

- **Store Management** — Create, update, and delete store locations
- **Product Catalog** — Manage the full product catalog with categories and pricing
- **Inventory Tracking** — Monitor stock levels per store, with low-stock warnings
- **Customer Management** — Register and manage customer records
- **Order Placement** — Place multi-item orders with automatic total calculation
- **Review System** — Product reviews stored in MongoDB (NoSQL)
- **Global Exception Handling** — Clean error responses across all endpoints
- **Stored Procedures** — MySQL procedures for sales analytics

---

## 📊 Stored Procedures

```sql
-- Monthly sales by store
CALL GetMonthlySalesForEachStore(2026, 6);

-- Total company sales
CALL GetAggregateSalesForCompany(2026, 6);

-- Top selling products by category
CALL GetTopSellingProductsByCategory(6, 2026);
```

---

## 🗂️ Project Structure

```
src/main/java/com/example/retail/
├── controller/        # REST controllers
├── service/           # Business logic
├── repository/        # JPA & MongoDB repositories
├── model/             # Entity classes
└── exception/         # Global exception handler

src/main/resources/
├── static/            # Frontend (retail-dashboard.html)
└── application.properties
```

---

## ⚙️ Setup & Run

### Prerequisites
- Java 21
- MySQL 8
- MongoDB
- Maven

### 1. Clone the repo
```bash
git clone https://github.com/mohsabbah7/retail-management-system.git
cd retail-management-system
```

### 2. Create the MySQL database
```sql
CREATE DATABASE retail_db;
```

### 3. Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/retail_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=retail_reviews
```

### 4. Run the app
```bash
mvn spring-boot:run
```

### 5. Open the dashboard
```
http://localhost:8080/retail-dashboard.html
```

---

## 📡 API Endpoints

| Resource | Endpoint | Methods |
|---|---|---|
| Stores | `/api/stores` | GET, POST, PUT, DELETE |
| Products | `/api/products` | GET, POST, PUT, DELETE |
| Inventory | `/api/inventory` | GET, POST, PATCH, DELETE |
| Customers | `/api/customers` | GET, POST, PUT, DELETE |
| Orders | `/api/orders` | GET, POST, PATCH, DELETE |
| Reviews | `/api/reviews` | GET, POST, DELETE |

---

## 👨‍💻 Author

**Mohammad** — Computer Science Student @ American University of Madaba  
[GitHub](https://github.com/mohsabbah7)
