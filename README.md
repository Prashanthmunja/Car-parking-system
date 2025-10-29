# 🚗 Car Parking System

A **Spring Boot** based RESTful web application designed to manage parking slots, handle bookings, and check availability in real time.  
This project demonstrates core Spring Boot concepts such as JPA, REST APIs, dependency injection, and layered architecture.

---

## 🧩 Features

- 🔐 **User Management** – Register and manage users.
- 🅿️ **Parking Slot Management** – Add, update, delete, and view available parking slots.
- 📅 **Booking Management** – Book, cancel, and view user-specific parking bookings.
- 🕒 **Availability Checking** – Check if a parking slot is free for a given time range.
- 💾 **H2 In-Memory Database** for quick testing.
- 📘 **Spring Data JPA** for data persistence.
- 🧠 **Lombok** used to reduce boilerplate code.
- 🔍 **RESTful Endpoints** easily testable using Postman.

---

## ⚙️ Technologies Used

| Layer | Technology |
|-------|-------------|
| Language | Java 17+ |
| Framework | Spring Boot |
| ORM | Spring Data JPA |
| Database | H2 Database |
| Tools | Maven, Lombok |
| Testing | Postman, JUnit (optional) |

---

## 🧱 Project Structure

carparking-system/
├── src/
│ ├── main/
│ │ ├── java/com/example/carparking_system/
│ │ │ ├── Controller/ # REST Controllers
│ │ │ ├── Model/ # Entity Classes
│ │ │ ├── Repository/ # JPA Repositories
│ │ │ ├── Service/ # Business Logic
│ │ │ └── CarParkingSystemApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql (optional test data)
│ └── test/...
├── pom.xml
└── README.md

yaml
Copy code

---

## ⚡ How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/Prashanthmunja/Car-parking-system.git
cd Car-parking-system
2. Build the Application
bash
Copy code
mvn clean install
3. Run the Application
bash
Copy code
mvn spring-boot:run
The app will start at
👉 http://localhost:8080

🧠 Example API Endpoints
🔹 Parking Slots
Method	Endpoint	Description
GET	/api/slots	Get all slots
GET	/api/slots/{id}	Get slot by ID
POST	/api/slots	Add a new slot
PUT	/api/slots/{id}	Update slot
DELETE	/api/slots/{id}	Delete slot

🔹 Bookings
Method	Endpoint	Description
POST	/api/bookings	Create a booking
GET	/api/bookings/user/{userId}	Get bookings by user
GET	/api/bookings/slot/{slotId}	Get bookings by slot
GET	/api/bookings/check-availability/{slotId}?startTime=...&endTime=...	Check availability of a slot

🗄️ Example Application Properties
properties
Copy code
spring.application.name=carparking-system
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Access the H2 console at:
🔗 http://localhost:8080/h2-console
Use JDBC URL: jdbc:h2:mem:testdb

🧰 Tools Used
Postman – for API testing

GitHub – for version control

Spring Initializr – to generate the starter project

IntelliJ IDEA / Eclipse – for development

✨ Future Enhancements
Add authentication and authorization (JWT)

Add payment integration for parking fees

Implement email notifications for booking confirmations

Build a frontend (React / Angular) dashboard

👨‍💻 Author
Prashanth Munja
📧 GitHub Profile
💻 Project: Car Parking System using Spring Boot
