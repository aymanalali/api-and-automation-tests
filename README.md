# Automation Assignment

## Overview
This project automates the testing of subscription packages on the STC TV website and validates API responses for adding new devices. It includes both frontend and API test cases, developed using Java, TestNG, and Rest Assured.

## Prerequisites
- Java (latest version)
- Maven
- IntelliJ IDEA or any preferred IDE

## Setup
1. **Clone the repository**:
   ```sh
   git clone https://github.com/aymanalali/automation-assignment.git
   ```
   

## Test Cases

### Frontend Test
- **URL**: https://subscribe.stctv.com/sa-en
- **Validation**: Checks subscription packages, types, prices, and currencies for Saudi Arabia, Kuwait, and Bahrain.

### API Test
- **Endpoint**: https://api.restful-api.dev/objects
- **Request Payload**:
  ```json
  {
    "name": "Apple Max Pro 1TB",
    "data": {
      "year": 2023,
      "price": 7999.99,
      "CPU model": "Apple ARM A7",
      "Hard disk size": "1 TB"
    }
  }
  ```
- **Validation**: Confirms the added device details like id, name, createdAt, year, price, etc.

## Reports
- Test reports are generated in the master branch directly.
- The reports provide detailed information on the test results, including pass/fail status for each test case.

## Important Points
- Developed using Java, TestNG, and Rest Assured.
- Ensured adherence to proper coding standards.
- Comprehensive test coverage for both frontend and API functionalities.
- api test path is: src/test/java/com/Intigral/tests/ApiTest.java
- Frontend Test path is: src/test/java/com/Intigral/tests/FrontendTest.java

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

For any questions or issues, please contact the project maintainer.
