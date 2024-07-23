This demonstrates usage of Spring Security with JWT authentication, includes user management, tweet posting, and a feed retrieval system.

## Features

**JWT Authentication**: Secure login with JWT tokens.<br>
**User Management**: Create and list users with role-based access.<br>
**Tweet Management**: Create, delete, and fetch tweets with pagination.<br>
**Role-based Access Control**: Admin and basic user roles.

## Structure

- **Controller Layer**: Handles incoming HTTP requests.<br>
- **DTOs (Data Transfer Objects)**: Defines request and response structures.<br>
- **Entities**: Represents the database models.<br>
- **Repositories**: Interfaces for database access.

## Security

- Uses Spring Security for authentication and authorization.<br>
- BCrypt for password hashing.<br>
- JWT for secure token generation and validation.
  
### Install the JDK
Download and install the recommended version of the JDK from the official Oracle website.<br>
Verify the installation by running `java -version` in the terminal.

### Install Maven
Download and install Maven from the official website.<br>
Verify the installation by running `mvn -version` in the terminal.

### Install Docker
Download and install Docker from the official website.<br>
Docker Compose is installed along with Docker. Verify the installation by running `docker-compose --version` in the terminal.

### Configure the Database
Any database compatible with JPA/Hibernate (PostgreSQL, MySQL) can be used.<br>
Configure the credentials and the database URL in the `application.properties` file.

## Getting Started

1. **Clone the repository**:
    ```
    git clone https://github.com/your-username/spring-security-example.git
    cd spring-security-example
    ```

2. **Configure the database**:<br>
    Update the `src/main/resources/application.properties` file with your database configuration.
   
3. **In `cd src/main/java/resources` Generate your private key**:
    ```
    openssl genrsa
    ```
4. **Derive your public key**
    ```
    openssl rsa -in private.pem -pubout -out public.pem
    ```

5. **In your project directory Build the project**:
    ```
    mvn clean install
    ```

6. **Run the application**:
    ```
    mvn spring-boot:run
    ```

## API Endpoints

### Authentication

- **Login**: `POST /login`
    - Request Body: 
      ```json
      {
          "username": "string",
          "password": "string"
      }
      ```
    - Response: 
      ```json
      {
          "token": "string",
          "expiresIn": 300
      }
      ```

### User Management

- **Create User**: `POST /users`
    - Request Body: 
      ```json
      {
          "username": "string",
          "password": "string"
      }
      ```
    - Response: `200 OK`

- **List Users**: `GET /users`
    - Requires `admin` scope.
    - Response: List of users.

### Tweet Management

- **Create Tweet**: `POST /tweets`
    - Requires authentication.
    - Request Body: 
      ```json
      {
          "content": "string"
      }
      ```
    - Response: `200 OK`

- **Delete Tweet**: `DELETE /tweets/{id}`
    - Requires authentication.
    - Response: `200 OK`

- **Get Feed**: `GET /feed`
    - Query Parameters: `page`, `pageSize`
    - Response: Paginated list of tweets.
