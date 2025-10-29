# Human Resource API

Backend API for Human Resource Management System built with Spring Boot and Maven.

## Tech Stack

- Java 17
- Spring Boot 3.2.0
- Maven
- Spring Boot Actuator

## Project Structure

```
HumanResource/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/humanresource/
│   │   │       ├── HumanResourceApplication.java
│   │   │       └── controller/
│   │   │           └── HealthController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6+ 

### Running the Application

1. Build the project:
```bash
maven clean install
```

2. Run the application:
```bash
maven spring-boot:run
```

Or run directly:
```bash
java -jar target/human-resource-api-1.0.0.jar
```

The application will start on `http://localhost:8080`

## API Endpoints

### Health Check

- **GET** `/api/health` - Custom health check endpoint
  - Returns: Application status, timestamp, service name, and version

- **GET** `/actuator/health` - Spring Boot Actuator health endpoint
  - Returns: Standard Spring Boot health information

## Example Response

```json
{
  "status": "UP",
  "timestamp": "2024-01-15T10:30:00",
  "service": "Human Resource API",
  "version": "1.0.0"
}
```

