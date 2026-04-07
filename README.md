# 🛒 Easy Basket – Full Stack Application

## 📌 Overview

Easy Basket is a full-stack web application built using **Spring Boot (Backend)**, **React (Frontend)**, and **MongoDB (Database)**.
It allows users to manage products (like laptops), add them to a cart, and control deletion based on cart status.

---

## 🚀 Features

* ➕ Add Product (Laptop name & price)
* 🔄 Update Product
* ❌ Delete Product (only if added to cart)
* 🛒 Add to Cart functionality
* 📦 MongoDB database integration
* 🔐 CSRF protection (Spring Security)
* 🌐 REST API architecture

---

## 🏗️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data MongoDB
* Spring Security

### Frontend

* React.js
* Axios

### Database

* MongoDB (using MongoDB Compass)

---

## 📁 Project Structure

```
easy (Spring Boot Backend)
 ┣ controller
 ┣ service
 ┣ repository
 ┣ model
 ┗ config

easy-frontend (React Frontend)
 ┗ src
    ┗ App.js
```

---

## ⚙️ Setup Instructions

### 🔧 Backend Setup

1. Navigate to backend folder:

```
cd easy
```

2. Configure MongoDB in `application.properties`:

```
spring.data.mongodb.uri=mongodb://localhost:27017/taskdb
server.port=8081
```

3. Run the application:

```
mvn spring-boot:run
```

4. Backend runs on:

```
http://localhost:8081
```

---

### ⚛️ Frontend Setup

1. Navigate to frontend folder:

```
cd easy-frontend
```

2. Install dependencies:

```
npm install
```

3. Start React app:

```
npm start
```

4. Frontend runs on:

```
http://localhost:3000
```

---

## 🔗 API Endpoints

| Method | Endpoint                | Description              |
| ------ | ----------------------- | ------------------------ |
| GET    | /api/products           | Get all products         |
| POST   | /api/products           | Add new product          |
| PUT    | /api/products/{id}      | Update product           |
| DELETE | /api/products/{id}      | Delete (only if in cart) |
| PUT    | /api/products/cart/{id} | Add to cart              |

---

## 🧪 Sample Request (POST)

```
POST /api/products
```

```json
{
  "name": "Dell Laptop",
  "price": 55000,
  "inCart": false
}
```

---

## 🗄️ Database Structure

**Database:** `taskdb`
**Collection:** `tasks`

```json
{
  "_id": "ObjectId",
  "name": "HP Laptop",
  "price": 60000,
  "inCart": false
}
```

---

## ⚠️ Important Notes

* MongoDB must be running locally (`localhost:27017`)
* Ensure correct database name (`taskdb`)
* Refresh MongoDB Compass to see updates
* React must use correct backend port (`8081`)

---

## 🔥 Future Enhancements

* 🛒 Separate Cart Page
* 🔐 JWT Authentication
* 🎨 Advanced UI (Tailwind CSS)
* 📦 Order Management System

---

## 👨‍💻 Author

Developed by Janani Narra

---

## 📄 License

This project is for educational purposes.
