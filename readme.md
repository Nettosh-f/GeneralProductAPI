# General Web Application API

A full Spring Boot REST API for a general web application with user and product management. This project provides a robust foundation for building web applications with Java and Spring Boot.

## Features

- 🔐 User Management: Register, update, delete, and retrieve users
- 📦 Product Management: Create, update, delete, and search products
- 🔒 Security: Basic authentication with role-based access control
- 📋 Validation: Request validation using Bean Validation
- 🧪 Testing: Comprehensive unit and integration tests
- 📝 Documentation: Detailed API documentation with OpenAPI/Swagger
- 🚀 Ready-to-use: Just add your custom business logic and go!

## Technology Stack

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- Spring Security
- H2 Database (for development)
- OpenAPI 3.0 (Springdoc)
- JUnit 5 & Mockito
- Maven

## Project Structure

The application follows a standard layered architecture:

- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Manages data access
- **Model Layer**: Domain entities
- **DTO Layer**: Data transfer objects for API contracts
- **Exception Layer**: Global exception handling

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.6.x or higher

### Building the Application

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Documentation

The API documentation is available via Swagger UI at:

```
http://localhost:8080/swagger-ui
```

## API Endpoints

### User Management

| Method | URL                            | Description                   | Access          |
|--------|--------------------------------|-------------------------------|-----------------|
| GET    | /api/v1/users                  | Get all users                 | Authenticated   |
| GET    | /api/v1/users/{id}             | Get user by ID                | Authenticated   |
| GET    | /api/v1/users/username/{username} | Get user by username      | Authenticated   |
| POST   | /api/v1/users                  | Create a new user             | Authenticated   |
| PUT    | /api/v1/users/{id}             | Update an existing user       | Authenticated   |
| DELETE | /api/v1/users/{id}             | Delete a user                 | Authenticated   |

### Product Management

| Method | URL                            | Description                   | Access          |
|--------|--------------------------------|-------------------------------|-----------------|
| GET    | /api/v1/products               | Get all products              | Authenticated   |
| GET    | /api/v1/products/{id}          | Get product by ID             | Authenticated   |
| GET    | /api/v1/products/search        | Search products by name       | Authenticated   |
| GET    | /api/v1/products/price         | Get products by max price     | Authenticated   |
| GET    | /api/v1/products/in-stock      | Get products in stock         | Authenticated   |
| POST   | /api/v1/products               | Create a new product          | Authenticated   |
| PUT    | /api/v1/products/{id}          | Update an existing product    | Authenticated   |
| DELETE | /api/v1/products/{id}          | Delete a product              | Authenticated   |

## Authentication

The API uses HTTP Basic Authentication for simplicity. In a production environment, this should be replaced with a more robust authentication mechanism such as JWT.

The application comes with two pre-configured users:

1. Regular User:
   - Username: `user`
   - Password: `password`
   - Roles: `USER`

2. Admin User:
   - Username: `admin`
   - Password: `admin`
   - Roles: `USER`, `ADMIN`

## Database Configuration

The application uses an H2 in-memory database by default, which is suitable for development and testing. For production, you should configure a persistent database like PostgreSQL, MySQL, or Oracle.

The H2 console is available at `http://localhost:8080/h2-console` with these connection details:

- JDBC URL: `jdbc:h2:mem:webapp_db`
- Username: `sa`
- Password: `<empty>`

## Testing

The project includes comprehensive tests for all layers:

- Unit tests for services and controllers
- Integration tests for repositories
- End-to-end tests for API endpoints

To run the tests:

```bash
mvn test
```

## Extending the Application

### Adding a New Entity

1. Create a model class in `com.example.webapp.model`
2. Create a DTO class in `com.example.webapp.dto`
3. Create a repository interface in `com.example.webapp.repository`
4. Create a service interface and implementation in `com.example.webapp.service`
5. Create a controller in `com.example.webapp.controller`
6. Add appropriate tests

### Customizing Security

Modify the `SecurityConfig` class to add or change security rules:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Add your custom security configuration here
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/custom/**").hasRole("CUSTOM_ROLE")
            );
        
        return http.build();
    }
}
```

## Production Considerations

Before deploying to production, consider the following:

1. Configure a persistent database (PostgreSQL, MySQL, etc.)
2. Implement a more robust authentication mechanism (JWT, OAuth2)
3. Add rate limiting to prevent abuse
4. Configure HTTPS with appropriate certificates
5. Implement proper logging and monitoring
6. Set up CI/CD pipelines for automated testing and deployment

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Disclaimer

This API foundation was created with the assistance of Claude (v3.7), an AI assistant by Anthropic.
For a full list of AI-created elements in this repository, contact me at https://github.com/Nettosh-f/GeneralProductAPI