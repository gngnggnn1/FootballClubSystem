# Football Club Management System

A web-based system to manage a five-a-side football club’s operations — players, teams, matches, registrations, and basic club admin.  
Designed for **Hohhot Qiangcheng FC** and built with **JDK 11**.

## Features

- **Player & Team Management** – Create/update players, assign to teams, manage positions and statuses.
- **Match Scheduling** – Create fixtures, record scores, track results.
- **Registrations** – Handle season or tournament sign-ups.
- **Basic Admin** – View lists, search, and edit core records.
- **Database-backed** – Schema and seed data provided via `soccersys.sql`.

> *Note:* Exact modules/screens depend on your implementation in `src/` and `WebContent/`.

## Tech Stack

- **Java (JDK 11)** — Core backend logic.
- **Java EE / Servlet + JSP** — Web application framework.
- **MySQL** — Relational database (`soccersys.sql` provided).
- **HTML / CSS / JavaScript** — Frontend.
- **Apache Tomcat 9+** — Recommended application server.

## Project Structure

```
FootballClubSystem/
├─ src/                   # Java source (servlets, DAO, models)
├─ WebContent/            # JSPs, static assets, WEB-INF
├─ build/                 # Compiled classes (if checked in)
├─ backup/                # Project backups / exports
├─ .settings/ .project .classpath  # Eclipse project files
├─ soccersys.sql          # DB schema & sample data
└─ README.md
```

## Getting Started

### Prerequisites
- **JDK 11+**
- **Apache Tomcat 9+** (Servlet 4.0 compatible)
- **MySQL 8.x**
- **Maven** *(optional)*

### 1) Database Setup
1. Create a database:
   ```sql
   CREATE DATABASE soccersys CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```
2. Import schema & seed data:
   ```bash
   mysql -u <user> -p soccersys < soccersys.sql
   ```
3. Note DB connection details (host, port, username, password).

### 2) Configure Database Credentials
Update credentials in your DB config file (e.g., `WEB-INF/web.xml`, `db.properties`, or DAO constants):
```
db.url=jdbc:mysql://localhost:3306/soccersys?useSSL=false&serverTimezone=UTC
db.user=your_user
db.password=your_password
```

### 3) Build & Run

#### Option A — Eclipse
1. Import into Eclipse: `File > Import > Existing Projects into Workspace`.
2. Add Tomcat 9 in Servers view.
3. Right-click project → `Run on Server`.

#### Option B — Manual Tomcat Deploy
1. Compile and ensure classes are in `WEB-INF/classes` and libs in `WEB-INF/lib`.
2. Deploy WAR file to `tomcat/webapps/`.
3. Start Tomcat and open:
   ```
   http://localhost:8080/FootballClubSystem/
   ```

### Configuration
- **JDBC Driver**: Ensure `mysql-connector-j` is in `WEB-INF/lib`.
- **Encoding**: Set UTF-8 for JSPs and database.
- **Optional Env Vars**:
  ```
  DB_URL, DB_USER, DB_PASSWORD
  ```

## Screenshots (Optional)
Add screenshots in `/docs/img/` showing:
- Player management
- Team list
- Match scheduling

## Roadmap
- Role-based authentication
- REST API endpoints
- CSV/Excel import & export
- Unit tests with JUnit + Mockito
- GitHub Actions CI/CD
- Dockerfile & Compose setup

## Contributing
1. Fork the repo & create a feature branch.
2. Follow conventional commit messages (`feat: ...`, `fix: ...`).
3. Open a Pull Request describing your changes.

## License
Add a `LICENSE` file to specify usage rights (e.g., MIT).

## Acknowledgments
- Built for **Hohhot Qiangcheng FC** (五人制).
- Thanks to contributors and testers.
