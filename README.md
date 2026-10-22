# ☕ Java Profile

A Spring Boot application, runnable locally with Maven or as a Docker container.

---

## 📋 Prerequisites

| Tool   | Needed for         |
|--------|--------------------|
| Java   | Local builds & run |
| Maven  | Local builds       |
| Docker | Container builds   |

---

* Note: Before running ensure DB and MAIL are set in env

```bash
# Linux: 
export DB_HOST=localhost
export DB_PORT=5432
export DB_USERNAME=postgres
exoprt DB_NAME='your-real-db-name'
export DB_PASSWORD='your-real-password'
export MAIL_USERNAME='your-real-mail-username'
export MAIL_PASSWORD='your-real-mail-password'
export CORS_ORIGINS='http://localhost:5173,http://localhost:3000'

# Windows PowerShell:
$env:DB_HOST="localhost"
$env:DB_PORT=5432
$env:DB_USERNAME="postgres"
$env:DB_NAME="your-real-db-name"
$env:DB_PASSWORD="your-real-password"
$env:MAIL_USERNAME="your-real-mail-username"
$env:MAIL_PASSWORD="your-real-mail-password"
$env:CORS_ORIGINS="http://localhost:5173,http://localhost:3000"
---
```
---

## 🛠️ Developer Builds

### Compile

```bash
mvn clean package -DskipTests
```

### Install

```bash
mvn clean install -DskipTests
```

### Run

```bash
mvn spring-boot:run
```

### Run using Java

```bash
java -jar /path/to/jar
```

---

## 🐳 Docker

### Build

```bash
docker build -t java-profile .
```

### Run (detached)

```bash
docker run -d -p 8082:8082 --name java-profile java-profile
```

### Run with logs

Runs in the foreground and removes the container when it stops.

```bash
docker run --rm -p 8082:8082 --name java-profile java-profile
```

Once running, the app is available at **http://localhost:8082**.

---

## ⚡ Quick Reference

| Task              | Command                                          |
|-------------------|--------------------------------------------------|
| Compile           | `mvn clean package -DskipTests`                  |
| Install           | `mvn clean install -DskipTests`                  |
| Run (Maven)       | `mvn spring-boot:run`                            |
| Run (JAR)         | `java -jar /path/to/jar`                         |
| Docker build      | `docker build -t java-profile .`                 |
| Docker run        | `docker run -d -p 8082:8082 --name java-profile java-profile` |
| Docker run (logs) | `docker run --rm -p 8082:8082 --name java-profile java-profile` |

### Useful Docker commands

```bash
docker logs -f java-profile     # follow logs of the detached container
docker stop java-profile        # stop the container
docker rm java-profile          # remove the container
```