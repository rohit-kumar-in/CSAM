# 🛡️ Cyber Security Asset Manager (CSAM) API

A professional-grade RESTful API designed to automate the discovery and risk-assessment of network assets. This project demonstrates the intersection of **Java Spring Boot development** and **Cyber Security domain expertise**.

## 🚀 Why This Project?
In a modern enterprise, "you cannot protect what you cannot see." This API serves as a centralized source of truth for hardware assets, automatically flagging legacy systems that pose a security risk to the organization.

## 🛠️ Tech Stack & Architecture
* Java 17 & Spring Boot 4.05 : For building a high-performance, scalable backend.
* **Spring Data JPA + MySQL**: For persistent, structured asset storage.
* **Jakarta Validation**: Implementing **RegEx-based Data Sanitization** for IP addresses (IPv4).
* **DTO Pattern**: Decoupling internal Entities from external API requests to prevent **Mass Assignment Vulnerabilities**.
* **Layered Architecture**: Controller → Service → Repository (Separation of Concerns).

## ✨ Key Features
* **Automated Risk Assessment**: The Service layer contains custom business logic that automatically flags devices as `Vulnerable` if they are running EoL (End of Life) operating systems like *Windows 7* or *Legacy* kernels.
* **Network Integrity**: Uses `@Pattern` validation to ensure only valid IPv4 addresses are stored, preventing database corruption and malformed data entry.
* **Interactive Documentation**: Integrated **OpenAPI/Swagger UI** for real-time API testing and documentation.

## 📋 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/assets` | Register a new asset (includes auto-risk logic) |
| `GET` | `/api/assets/vulnerable` | Retrieve all high-risk/vulnerable assets |
| `GET` | `/swagger-ui.html` | Access interactive API documentation |

### Sample Request Payload
```json
{
  "deviceName": "Finance-Laptop-01",
  "ipAddress": "192.168.1.15",
  "osType": "Windows 7"
}
```
*Resulting Status: `Vulnerable` (Logic-driven)*

## ⚙️ Setup Instructions
1.  **Database**: Create a MySQL schema named `security_db`.
2.  **Configuration**: Update `src/main/resources/application.properties` with your MySQL credentials.
3.  **Run**: Execute `./mvnw spring-boot:run` or run the main class in your IDE.
4.  **Verify**: Visit `http://localhost:8080/swagger-ui.html` to test the endpoints.

---

### 💡 Pro-Tip for your Resume:
Under the description for this project, add this bullet point:
> *"Implemented a custom risk-scoring engine within the Service layer to automate the identification of End-of-Life (EoL) systems, reducing manual audit time for security teams."*
