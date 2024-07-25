# FXDealsLogger

FXDealsLogger is a Spring Boot application designed to log foreign exchange deals. This application includes features like deal logging, H2 database integration for development and testing, and Docker support.

## Features

- **Deal Logging**: Log details of foreign exchange deals.
- **In-Memory H2 Database**: Default configuration for quick development and testing.
- **Docker Support**: Containerize the application for easy deployment and scalability.
- **H2 Console**: Access the H2 database console for easy data inspection and debugging.
- **Integration with MySQL**: Optionally use MySQL for more persistent data storage.
- **REST API**: Provide endpoints for creating, retrieving, and managing foreign exchange deals.

## Prerequisites

- Docker
- Docker Compose
- Java 17
- Maven

## Getting Started

### Running the Application with Docker

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Mahmoud-ghb/FXDealsLogger.git
    cd FXDealsLogger
    ```

2. **Build the Docker image**:
    ```bash
    docker-compose build
    ```

3. **Start the application**:
    ```bash
    docker-compose up
    ```

4. **Access the application**:
   - Application: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`

### Running the Application without Docker

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Mahmoud-ghb/FXDealsLogger.git
    cd FXDealsLogger
    ```

2. **Build the project using Maven**:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application**:
   - Application: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`

### Application Configuration

The application is pre-configured to use an in-memory H2 database for development and testing. You can change the database configuration in `application.properties` if needed.

#### H2 Database Configuration (Default)

```properties
spring.datasource.url=jdbc:h2:mem:fxdeals;DB_CLOSE_DELAY=-1
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=P@ssw0rd
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

MySQL Configuration
To use MySQL, update application.properties:

```properties
spring.datasource.url=jdbc:mysql://db:3306/fxdeals
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=sa
spring.datasource.password=P@ssw0rd
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
And modify the docker-compose.yml to use the MySQL service:


```properties
version: '3.8'

services:
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: fxdeals
      MYSQL_USER: sa
      MYSQL_PASSWORD: P@ssw0rd
    ports:
      - "3306:3306"

  application:
    depends_on:
      - db
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/fxdeals
      SPRING_DATASOURCE_DRIVER_CLASS_NAME: com.mysql.cj.jdbc.Driver
      SPRING_DATASOURCE_USERNAME: sa
      SPRING_DATASOURCE_PASSWORD: P@ssw0rd
      SPRING_DATASOURCE_PLATFORM: mysql
      SPRING_JPA_DATABASE_PLATFORM: org.hibernate.dialect.MySQLDialect
      SPRING_JPA_HIBERNATE_DDL_AUTO: update
      SPRING_JPA_SHOW_SQL: "true"
      
```
##Testing
**To run the tests**
Copy code:

```bash
mvn test
```

##Docker Commands
Build Docker images:


```bash
docker-compose build
```
Start the application:


```bash
docker-compose up
```
Stop the application:


```bash
docker-compose down
```


View logs:


```bash
docker-compose logs
```

**Access the H2 Console:**
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:fxdeals`
- Username: `sa`
- Password: `P@ssw0rd`

## REST API
   **Endpoints**
**Create a Deal** 
- URL: `/api/deals`
- Method: `POST`
- Content-Type: `application/json`

   **Request Body**   
   ```properties
      {
         "dealId": "string",
         "fromCurrency": "string",
         "toCurrency": "string",
         "dealTimestamp": "string",
         "dealAmount": number
      }
   ```
## Contact

**For any questions or suggestions, feel free to contact the maintainer**:
- Email: `mahmoudabdulsalam962@gmail.com`
