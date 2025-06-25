# 💸 bank-API

**Financial Management Microservice and Pix Key System**

Project developed with Spring Boot for financial management, integrating features such as account management, transactions, and Pix keys. Optimized for high performance, security, and efficient memory usage, with support for PostgreSQL and in-memory mode for quick testing.

---

## 📋 Requirements
- [Java 21 (JDK 21+)](https://adoptium.net/temurin/releases/?version=21)
- [Apache Maven 3.6+](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/) (optional, to run PostgreSQL)
- [Git](https://git-scm.com/)

---

## 🚀 Project Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Vinis22/bank-API.git
   cd bank-API
   ```
2. **Environment configuration:**
   - Create the `.env` file based on the example:
     ```bash
     cp .env.example .env
     ```
   - Edit the `.env` file with your PostgreSQL credentials:
     ```env
     DATABASE_HOST=localhost
     DATABASE_PORT=5432
     DATABASE_NAME=bankapp
     DATABASE_USER=your_user
     DATABASE_PASSWORD=your_password
     ```

---

## ⚡️ Running Options

### 🟢 Run in in-memory mode (no external database)
1. Comment out the datasource settings in `src/main/resources/application.yml`:
   ```yaml
   #spring.datasource.url=jdbc:postgresql://db:5432/bankapp
   #spring.datasource.username=your_user
   #spring.datasource.password=your_password
   spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
   ```
2. Start the application:
   ```bash
   mvn spring-boot:run
   ```

### 🐘 Run with PostgreSQL via Docker
1. Start the database:
   ```bash
   docker-compose up -d db
   ```
2. Start the application:
   ```bash
   mvn spring-boot:run
   ```

### 🐳 Run everything with Docker (app + database)
```bash
docker-compose up --build
```

---

## ✅ Tests
- Run tests with H2 (in-memory database):
  ```bash
  mvn test
  ```
- Build without running tests:
  ```bash
  mvn clean package -DskipTests
  ```

---

## 📄 Main API Endpoints

| Method | Endpoint                | Description                  |
|--------|------------------------|------------------------------|
| POST   | `/api/pix`             | Register a new Pix key       |
| GET    | `/api/pix`             | List all Pix keys            |
| GET    | `/api/pix/{id}`        | Get Pix key by ID            |
| GET    | `/api/pix/key/{key}`   | Get Pix key by value         |

- **Health Check:**
  ```http
  GET /actuator/health
  ```

---

## 🐞 Troubleshooting - Common Issues
- **Compilation error in `AuthService.java`:**
  - Check if the imported custom exceptions exist.
  - If missing, create the exception classes or adjust the imports.
- **.env configuration:**
  - Make sure the variables are correct and without extra spaces.
  - Check if the database is accessible at the configured URL.
- **Failed to start PostgreSQL with Docker:**
  - Check if port 5432 is free.
  - Check the container logs with `docker logs container_name`.

---

## ⚙️ Development Suggestions
- Standardize exceptions using custom classes.
- Add comments to complex parts of the code, such as JWT authentication.
- Integrate CI/CD pipelines (e.g., GitHub Actions) for test and deployment automation.
- Improve project security by configuring sensitive variables in `.env` and using Spring Security.

---

## 🧹 Cleaning up Docker Containers
To stop and remove the Docker services used by the project:
```bash
docker-compose down -v
```

---

## 📜 License
This project is licensed under the MIT license. See the [LICENSE](LICENSE) file for more details.

---

## 🤝 Contributions
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a branch for your feature:
   ```bash
   git checkout -b feature/feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add new feature'
   ```
4. Push the branch:
   ```bash
   git push origin feature/feature-name
   ```
5. Open a Pull Request.

---

## 👤 Author
[Vinicius Alencar](https://github.com/Vinis22)
