# Appium Apps

## Overview
This project showcases various Appium applications developed for mobile automation testing. The framework is designed to facilitate the interaction with mobile applications by providing functionalities to start and stop the emulator directly from the IDE.

## Features
- **Emulator Control**: Easily start and stop the Android emulator.
- **Automation Scripts**: Execute automated tests on mobile applications.
- **Selenium Integration**: Leverage Selenium WebDriver for robust automation.
- **Extensive Reporting**: Generate detailed test reports.
- **Modular Code Structure**: Organized for easy maintenance and scalability.

## Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:
- Java JDK (version 1.8 or higher)
- Maven
- Appium
- Android SDK
- Spring Tool Suite (STS)

### Project Structure
```
Appium_Apps
│
├── src
│   ├── main
│   └── test
├── pom.xml
└── README.md
```

### Dependencies
The project is built using Maven and includes the following dependencies:

### `pom.xml` Configuration
Ensure that your `pom.xml` is set up correctly with the following content:

```xml
<project xmlns="https://maven.apache.org/POM/4.0.0"
         xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>Appium</groupId>
    <artifactId>Appium</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.9.2</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.10.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>7.3.0</version>
        </dependency>
    </dependencies>
</project>
```

### Setting Up the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/princu2701/Appium_Apps.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Appium_Apps
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Running Tests
To execute the tests, navigate to the `src/test` directory and run the following command in STS:
- Right-click on the `maintest` class and select **Run As > TestNG Test**.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements
- Appium Documentation
- Selenium Documentation
