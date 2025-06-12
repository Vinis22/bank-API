#bank-API - Financial Management Microservice and Pix Key System
Project developed with Spring Boot for financial management, integrating features such as account management, transactions and Pix keys. The service is optimized for high performance, security and efficient use of memory, with support for PostgreSQL and in-memory mode for quick testing.

#📋 Requirements
Java 21 (JDK 21+)

Apache Maven 3.6+

Docker (optional, to run PostgreSQL)

Git

#🚀 Project Configuration
1. Clone the repository:
bash
Copy
Edit
git clone https://github.com/Vinis22/bank-API.git
cd bank-API
2. Environment Configuration
Create the .env file based on the example:

bash
Copy
Edit
cp .env.example .env
Edit the .env with your PostgreSQL database credentials:

env
Copy
Edit
DATABASE_HOST=localhost
DATABASE_PORT=5432
DATABASE_NAME=bankapp
DATABASE_USER=your_username
DATABASE_PASSWORD=your_password
3. Execution options
A) Run without a database (in-memory mode)
Comment out the datasource settings in src/main/resources/application.yml:

yaml
Copy
Edit
spring.datasource.url=jdbc:postgresql://db:5432/bankapp
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
Execute:

bash
Copy
Edit
mvn spring-boot:run
B) Running with PostgreSQL via Docker
Initialize the database with Docker Compose:

bash
Copy
Edit
docker-compose up -d db
Then run the application:

bash
Copy
Edit
mvn spring-boot:run
#▶️ How to run with Docker (app + bank):
bash
Copy
Edit
docker-compose up --build
#✅ Tests
Run tests with H2 bank (in-memory):

bash
Copy
Edit
mvn test
Build without running tests:

bash
Copy
Edit
mvn clean package -DskipTests

#📄 Main API endpoints
Method Endpoint Description
POST /api/pix Register a new Pix key
GET /api/pix List all Pix keys
GET /api/pix/{id} Search for Pix key by ID
GET /api/pix/key/{key} Search for Pix key by value

Health Check
bash
Copy
Edit
GET /actuator/health

#🐞 Troubleshooting - Common Problems
Compilation error in AuthService.java:

Check if the imported custom exceptions exist.

If they are missing, create exception classes or adjust the imports.

.env configuration:

Make sure the variables are correct and without extra spaces.

Check if the database is accessible at the configured URL.

Failed to start Docker PostgreSQL:

Check if port 5432 is free.

Check the container logs with docker logs container_name.

#⚙️ Development Suggestions
Standardize exceptions using custom classes.

Add comments in the code for complex parts like JWT authentication.

Integrate CI/CD pipelines (e.g. GitHub Actions) for test and deployment automation.

Improve project security by configuring sensitive variables in .env and using Spring Security.

#📜 License
This project is licensed under the MIT license. See the LICENSE file for more details.

#🤝 Contributions
Contributions are welcome! To contribute:

Fork the repository.

Create a branch for your feature (git checkout -b feature/feature-name).

Commit your changes (git commit -m 'Add new feature').

Push the branch (git push origin feature/feature-name).

Open a Pull Request.

#👤 Author
Vinicius Alves - GitHub

#🧹 Cleaning up Docker Containers
To stop and remove the Docker services used by the project:

bash
Copy
Edit
docker-compose down -v
