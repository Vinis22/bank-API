# **BankApp - Financial Management & Pix Key System**

BankApp is a microservice developed with **Spring Boot** for financial management, integrating features such as account management, transactions and Pix key system. It uses modern technologies to ensure high performance, security and efficiency in memory usage.

## **📋 Prerequisites**

Make sure the following tools are installed on your system:

- **Java 21** (JDK 21+)
- **Apache Maven** (3.6+)
- **Docker** (optional, to run PostgreSQL)
- **Git** (to clone the repository)

## **⚙️ Single Script Configuration and Execution**

This project provides an **automated script** to quickly configure and run the application.

### **🚀 Steps Automated by the Script:**

1. Cloning the repository

2. Creating the `.env` file

3. Initializing the database with Docker

4. Building the application

5. Initializing the backend via Docker Compose

## **📦 Running the Setup**

1. **Create the `setup.sh` file** in the desired directory:
```bash
touch setup.sh && chmod +x setup.sh
```

2. **Copy and paste the content below into `setup.sh`:**
```bash
#!/bin/bash

echo "📦 Starting BankApp setup..."

REPO_URL="https://github.com/Vinis22/dockerized-pdf-report-generator.git"
PROJECT_NAME="BankApp"

echo "🔗 Cloning the repository..."
git clone "$REPO_URL" "$PROJECT_NAME"
cd "$PROJECT_NAME" || exit

echo "⚙️ Setting up environment..."

if [ ! -f ".env" ]; then
echo "📝 Creating .env file from example..."
cp .env.example .env
fi

echo "🐳 Initializing PostgreSQL database with Docker..."
docker-compose up -d db

echo "🏗️ Building the application..."
mvn clean package -DskipTests

echo "🚀 Uploading the application with Docker..."
docker-compose up --build

echo "✅ Application available at: http://localhost:8080"
```

3. **Run the script:**
```bash
./setup.sh
```

## **🧪 Tests**

- Run all tests with H2 (in-memory database):
```bash
mvn test
```

- Build without running the tests:
```bash
mvn clean package -DskipTests
```

## **📄 API Endpoints**

### 🔑 Pix Key Management

| HTTP Method | Endpoint | Description |
|-------------|------------------------|------------------------------------|
| `POST` | `/api/pix` | Register a new Pix key |
| `GET` | `/api/pix` | List all Pix keys |
| `GET` | `/api/pix/{id}` | Query Pix key by ID |
| `GET` | `/api/pix/key/{key}` | Query Pix key by value |

### 💓 Health Check
- Check if the application is active:
```bash
GET /actuator/health
```

## **🛠️ Execution Modes**

### 🔹 Without database (memory)
1. Edit the `application.yml`:
```yaml
# spring.datasource.url=jdbc:postgresql://db:5432/bankapp
# spring.datasource.username=your_user
# spring.datasource.password=your_password
# spring.jpa.hibernate.ddl-auto=update
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```

### 🔹 With database (PostgreSQL)
1. Create the `.env` file:
```bash
cp .env.example .env
```

2. Edit with your credentials:
```env
DATABASE_HOST=localhost
DATABASE_PORT=5432
DATABASE_NAME=bankapp
DATABASE_USER=your_username
DATABASE_PASSWORD=your_password
```

3. Start PostgreSQL:
```bash
docker-compose up -d db
```

## **🧹 Finish and Clean Up**

To stop and remove Docker services:
```bash
docker-compose down -v
```

## **📁 Jasper Reporting Framework**

Make sure the `.jasper` files are in the correct directory:
```
src/main/resources/reports/
```

## **🤝 Contributing**

Contributions are Welcome!

1. Fork the project

2. Create a branch: `git checkout -b feature/nova-feature`
3. Commit: `git commit -am 'Add new feature'`
4. Push: `git push origin feature/nova-feature`
5. Open a Pull Request

## **👥 Author**

- Vinícius S. – [GitHub](https://github.com/Vinis22)
