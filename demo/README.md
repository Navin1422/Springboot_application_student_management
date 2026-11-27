# 🌱 Spring Boot Demo — REST API with MySQL

A beginner Spring Boot REST API project built during training. Connects to a MySQL database and exposes full CRUD operations via HTTP endpoints.

---

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.2.0 |
| Spring Web MVC | Included |
| Spring Data JPA | Included |
| Spring Security | Included |
| MySQL Connector | Latest |
| Maven | 3.9.x |

---

## 📁 Project Structure

```
demo/
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java          ← App entry point
│   ├── SecurityConfig.java           ← Disables CSRF for API testing
│   ├── Controller/
│   │   ├── MyController.java         ← Main REST controller
│   │   └── HelloController.java      ← Test controller
│   ├── Entity/
│   │   └── t_three_entity.java       ← Maps to MySQL table
│   └── Repository/
│       └── t_three_repo.java         ← DB operations (JpaRepository)
├── src/main/resources/
│   └── application.properties        ← DB config
└── pom.xml                           ← Dependencies
```

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=demo
spring.datasource.url=jdbc:mysql://localhost:3306/thursday
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Note:** `ddl-auto=update` automatically creates/updates DB tables on startup.

---

## 🗄️ Entity — `t_three_entity`

Maps to the `t_three_entity` table in the `thursday` MySQL database.

| Field | Type | Description |
|-------|------|-------------|
| `numda` | `int` | Primary Key (ID) |
| `nameda` | `String` | Name |
| `salary` | `double` | Salary amount |
| `slab` | `String` | Salary slab (e.g. A, B, C) |

---

## 🚀 Running the App

**Prerequisites:**
- Java 21+
- MySQL running on `localhost:3306`
- Database `thursday` created

```bash
# Clone / navigate to project
cd demo

# Run the app
./mvnw spring-boot:run
```

App starts at: **http://localhost:8080**

---

## 📡 API Endpoints

### GET Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| `GET` | `/tones` | Get all records |
| `GET` | `/find/{id}` | Get record by ID |
| `GET` | `/hello` | Hello world test |

### POST Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| `POST` | `/insert` | Insert single record |
| `POST` | `/insertmany` | Insert multiple records |

### PUT Endpoint

| Method | URL | Description |
|--------|-----|-------------|
| `PUT` | `/update/{id}` | Update record by ID |

### DELETE Endpoint

| Method | URL | Description |
|--------|-----|-------------|
| `DELETE` | `/delete/{id}` | Delete record by ID |

---

## 🧪 Testing with Thunder Client (VS Code)

### Get All Records
```
GET  http://localhost:8080/tones
```

### Get By ID
```
GET  http://localhost:8080/find/201
```

### Insert Single
```
POST  http://localhost:8080/insert
Body (JSON):
{
  "numda": 301,
  "nameda": "ravi",
  "salary": 60000.0,
  "slab": "B"
}
```

### Insert Many
```
POST  http://localhost:8080/insertmany
Body (JSON):
[
  { "numda": 401, "nameda": "alice", "salary": 80000.0, "slab": "A" },
  { "numda": 402, "nameda": "bob",   "salary": 50000.0, "slab": "C" }
]
```

### Update By ID
```
PUT  http://localhost:8080/update/201
Body (JSON):
{
  "nameda": "joanna",
  "salary": 95000.0,
  "slab": "A"
}
```

### Delete By ID
```
DELETE  http://localhost:8080/delete/201
```

---

## 🔐 Security Note

CSRF protection is **disabled** in `SecurityConfig.java` to allow REST API testing via Thunder Client / Postman.

> ⚠️ Enable proper authentication (JWT / OAuth2) before deploying to production.

---

## 📚 Key Concepts Learned

- Setting up a Spring Boot project from [Spring Initializr](https://start.spring.io)
- Connecting Spring Boot to MySQL using JPA
- Creating `@Entity`, `@Repository`, `@RestController`
- CRUD operations: `GET`, `POST`, `PUT`, `DELETE`
- Using `JpaRepository` built-in methods: `findAll()`, `findById()`, `save()`, `saveAll()`, `deleteById()`
- Testing APIs with Thunder Client
- Fixing CSRF 403 errors with `SecurityConfig`
- Package structure rules for `@ComponentScan`
