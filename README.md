# Inventory Management System

This is a Java-based Inventory Management System project. It provides tools for managing products, stock, and related business operations. The project uses Ant for building and supports modular Java development.

## Features

- Product registration and update dialogs
- Inventory tracking and management
- Reporting capabilities (JasperReports integration)
- Modern UI with FlatLaf
- Database connectivity (MySQL)
- PDF export (iText, OpenPDF)
- Extensible with additional libraries

## Project Structure

```
.
├── build.xml                # Main Ant build script
├── manifest.mf              # JAR manifest file
├── lib/                     # Third-party libraries (JARs)
├── nbproject/               # NetBeans project configuration
│   ├── build-impl.xml
│   ├── project.properties
│   └── project.xml
├── src/                     # Application source code
├── test/                    # Unit tests
└── build/                   # Build output (generated)
```

## Requirements

- Java 19 or later
- Apache Ant 1.8.0 or higher
- MySQL (for database backend)
- NetBeans IDE (recommended for development)

## Setup

1. **Clone the repository**  
   Download or clone the project to your local machine.

2. **Install dependencies**  
   Ensure all required JARs are present in the `lib/` directory.

3. **Configure the database**  
   - Create a MySQL database for the application.
   - Update database connection settings in the source code or configuration files as needed.

## Building the Project

To build the project, run the following command in the project root:

```sh
ant clean build
```

The compiled JAR will be located in the `dist/` directory.

## Running the Application

After building, run the application with:

```sh
java -jar dist/Inventory_Management_System.jar
```

## Running Tests

To execute unit tests:

```sh
ant test
```

Test results will be available in the `build/test/results/` directory.

<!-- ## Continuous Integration

You can automate builds and tests using GitHub Actions.  
Add a workflow file like `.github/workflows/ci.yml`:

```yaml
name: Java CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v3
      - name: Set up JDK 19
        uses: actions/setup-java@v3
        with:
          java-version: '19'
          distribution: 'temurin'
      - name: Build with Ant
        run: ant clean build
      - name: Run tests
        run: ant test
``` -->

## Customization

You can customize build steps by editing [build.xml](build.xml) or overriding targets as described in the comments within the file.

## Libraries

The project uses several third-party libraries, including:

- FlatLaf (UI)
- JasperReports (reporting)
- iText, OpenPDF (PDF export)
- MySQL Connector/J (database)
- Apache Commons libraries

All dependencies are located in the [lib/](lib/) directory.

## License

This project is provided as-is for educational