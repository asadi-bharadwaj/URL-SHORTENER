# URL Shortener

A simple URL Shortener application built using Spring Boot and MySQL.

## Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven

## Features

- Generate short URLs for long URLs.
- Retrieve the original URL from a short URL.
- Store shortened URLs in a MySQL database.
- REST API endpoints for creating and retrieving URLs.

## Prerequisites

Ensure you have the following installed:

- Java 17+ (or the version used in your project)
- Maven
- MySQL Server

## Setup Instructions

### Clone the Repository
```bash
git clone <your-repo-url>
cd url-shortener
```

### Configure MySQL Database

Create a MySQL database and update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### API Endpoints

#### Shorten a URL
- **Endpoint:** `POST /api/shorten`
- **Request Body:**
  ```json
  {
    "originalUrl": "https://example.com"
  }
  ```
- **Response:**
  ```json
  {
    "shortUrl": "http://localhost:8080/s/a1b2c3"
  }
  ```

#### Redirect to Original URL
- **Endpoint:** `GET /s/{shortCode}`
- **Example:** `GET http://localhost:8080/s/a1b2c3`
- **Response:** Redirects to the original URL.

## Deployment

- Package the application:
  ```bash
  mvn package
  ```
- Run the JAR file:
  ```bash
  java -jar target/url-shortener-0.0.1-SNAPSHOT.jar
  ```

## Future Enhancements
- Add authentication and rate limiting.
- Implement analytics for URL access.
- Improve error handling and validation.

## License

This project is open-source.


