# 🌾 AgroRoot – Smart Agriculture Platform

AgroRoot is a modern agriculture platform that connects **farmers directly with customers** and provides **AI-powered farming guidance**.
The platform helps farmers sell their crops directly and get intelligent suggestions about farming, fertilizers, and crop management.

AgroRoot aims to **bridge the gap between farmers and consumers using technology and AI**.

---

# 🚀 Key Features

🌱 Farmer registration and management
🛒 Direct farmer-to-customer product marketplace
🤖 AI-powered agriculture chatbot
📦 Product listing and management
🔗 RESTful API architecture
🔐 Secure backend configuration

---

# 🛠 Tech Stack

Backend Technologies

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* REST APIs

AI Integration

* Groq AI API

Development Tools

* Maven
* Git
* GitHub

---

# 📂 Project Structure (Backend)

```
agroroot-backend
│
├── src
│
│   ├── main
│   │
│   │   ├── java
│   │   │
│   │   │   └── com.agroroot
│   │   │
│   │   │       ├── config
│   │   │       │   └── SecurityConfig.java
│   │   │
│   │   │       ├── controller
│   │   │       │   ├── AiChatController.java
│   │   │       │   ├── CustomerController.java
│   │   │       │   ├── FarmerController.java
│   │   │       │   └── ProductController.java
│   │   │
│   │   │       ├── model
│   │   │       │   ├── Customer.java
│   │   │       │   ├── Farmer.java
│   │   │       │   └── Product.java
│   │   │
│   │   │       ├── repository
│   │   │       │   ├── CustomerRepository.java
│   │   │       │   ├── FarmerRepository.java
│   │   │       │   └── ProductRepository.java
│   │   │
│   │   │       ├── service
│   │   │       │   ├── AiService.java
│   │   │       │   ├── CustomerService.java
│   │   │       │   ├── FarmerService.java
│   │   │       │   └── ProductService.java
│   │   │
│   │   │       └── AgrorootBackendApplication.java
│   │
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.properties
│
└── pom.xml
```

---

# ⚙️ How to Setup the Project

Follow these steps to run the AgroRoot backend locally.

---

## 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/agroroot-backend.git
```

```
cd agroroot-backend
```

---

## 2️⃣ Setup MySQL Database

Create a database in MySQL:

```
CREATE DATABASE agroroot;
```

---

## 3️⃣ Configure Database

Open:

```
src/main/resources/application.properties
```

Add your database configuration:

```
spring.datasource.url=jdbc:mysql://localhost:3306/agroroot
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4️⃣ Run the Application

Run the Spring Boot application:

```
mvn spring-boot:run
```

Or run the main class:

```
AgrorootBackendApplication.java
```

Server will start on:

```
http://localhost:8080
```

---

# 🔗 API Endpoints

### Farmers

```
GET    /api/farmers
POST   /api/farmers
```

### Customers

```
GET    /api/customers
POST   /api/customers
```

### Products

```
GET    /api/products
POST   /api/products
```

### AI Farming Assistant

```
POST /api/ai/chat
```

Example request:

```
{
 "message": "How to grow wheat?"
}
```

---

# 🌱 Future Improvements

* Farmer dashboard
* Order management system
* Payment integration
* Weather-based crop suggestions
* Mobile application

---

# 👨‍💻 Author

AgroRoot Project
Smart Agriculture Platform
