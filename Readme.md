```markdown
# Inventory Management System

A simple Java-based console Inventory Management System for managing products, stock, and inventory operations. The application provides CRUD operations for products and uses a MySQL database for persistence.

---

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Project Structure](#project-structure)  
- [Prerequisites](#prerequisites)  
- [Database Schema](#database-schema)  
- [Configuration](#configuration)  
- [Build & Run](#build--run)  
- [Usage](#usage)  
- [Validation & Behavior](#validation--behavior)  
- [Troubleshooting](#troubleshooting)  
- [Contributing](#contributing)  
- [License](#license)

---

## About

This repository contains a lightweight inventory management console application written in Java. It's intended for small-scale use and educational purposes. Key responsibilities are split between the UI, service layer, and DAO (data access) layer.

---

## Features

- Add new products
- Update existing products
- Delete products
- View all products
- Search product by ID
- Persistent storage using MySQL

---

## Project Structure

- src/
  - Main.java                     — Application entry point
  - ui/InventoryUI.java           — Console-based user interface
  - service/InventoryService.java — Business logic and validation
  - dao/ProductDAO.java           — Database access (JDBC)
  - model/Product.java            — Product model / POJO
  - util/DBConnection.java        — MySQL connection helper
- Readme.md                       — This file

---

## Prerequisites

- Java JDK 8 or newer
- MySQL server (local or remote)
- MySQL JDBC driver (mysql-connector-java) on the classpath when running
- Basic knowledge of compiling/running Java applications or using an IDE (IntelliJ/Eclipse)

---

## Database Schema

The application expects a database named `inventory_db` and a table `products` with the following schema:

```sql
CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

CREATE TABLE IF NOT EXISTS products (
  product_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255),
  quantity INT NOT NULL DEFAULT 0,
  price DOUBLE NOT NULL,
  barcode VARCHAR(255)
);
```

You can insert a sample record for testing:

```sql
INSERT INTO products (product_id, name, category, quantity, price, barcode)
VALUES (1, 'Sample Product', 'General', 10, 19.99, '1234567890');
```

---

## Configuration

DB connection settings are defined in `src/util/DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
private static final String USER = "root";
private static final String PASSWORD = "Santosh";
```

Important:
- Update `USER` and `PASSWORD` to match your MySQL credentials.
- If your database runs on a different host/port or you use SSL or timezone settings, adjust the `URL` accordingly.
- Do not commit production credentials into version control.

---

## Build & Run

Option A — Command line (no build tool):

1. Compile all Java files (run from the repository root):

   - On Unix/macOS (bash):
     ```bash
     mkdir -p bin
     javac -d bin $(find src -name "*.java")
     ```

   - On Windows (PowerShell):
     ```powershell
     mkdir bin
     javac -d bin (Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName })
     ```

2. Run the program (ensure MySQL connector JAR is on the classpath):

   ```bash
   # Example: assuming mysql-connector-java-8.0.x.jar is in lib/
   java -cp "bin:lib/mysql-connector-java-8.0.34.jar" Main
   ```

   On Windows use semicolon `;` instead of `:` in the classpath.

Option B — IDE:
- Open the project in IntelliJ IDEA or Eclipse, add the MySQL connector to project libraries, set `src` as source root, then run the `Main` class.

Option C — Add a build tool:
- For convenience and reproducibility, consider converting the project to use Maven or Gradle and add the MySQL connector dependency.

---

## Usage

When you run the app, you will see a menu:

```
=== Inventory Management System ===
1. Add Product
2. View All Products
3. Update Product
4. Delete Product
5. Search Product
6. Exit
Enter choice:
```

- Follow prompts to enter product details (ID, name, category, quantity, price, barcode).
- Example: adding a product
  - ID: 101
  - Name: "Widget"
  - Category: "Gadgets"
  - Quantity: 25
  - Price: 12.99
  - Barcode: "9876543210"

---

## Validation & Behavior

- addProduct: rejects if product ID already exists, quantity < 0, or price <= 0.
- updateProduct: rejects if quantity < 0 or price <= 0.
- deleteProduct: removes product row with matching product_id.
- searchProduct: returns product or "Product not found."

The service layer handles validation and delegates DB operations to the DAO.

---

## Troubleshooting

- "Failed to connect to database." — Check:
  - MySQL service running and accepting connections.
  - Database `inventory_db` exists and `products` table created.
  - Credentials in `DBConnection.java` are correct.
  - JDBC driver (mysql-connector-java) is on the classpath when running the app.

- JDBC Driver issues:
  - Download the connector from https://dev.mysql.com/downloads/connector/j/ and place the JAR in a `lib/` folder or add via your build tool/IDE.

- SQL Exceptions:
  - Run the SQL schema commands manually to confirm table structure and permissions.

---

## Contributing

- Feel free to open issues or submit pull requests.
- Suggested improvements:
  - Add unit tests
  - Convert to Maven/Gradle
  - Add logging (SLF4J + Logback)
  - Improve input validation and UX
  - Add a GUI or web frontend
  - Use connection pooling (HikariCP) for performance

---

## License

No license specified in the repository. If you want to make this project open-source, consider adding an SPDX license file (e.g., MIT, Apache-2.0). If you want, I can add a recommended LICENSE file.

---

If you'd like, I can:
- Commit this README.md to the repository,
- Convert the project into a Maven project,
- Or add a sample SQL seed file and a run script.

Tell me which action you want next and I will proceed.
```
