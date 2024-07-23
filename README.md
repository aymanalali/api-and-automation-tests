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
2. **Navigate to the project directory**:
   ```sh
   cd automation-assignment
   ```
3. **Build the project**:
   ```sh
   mvn clean install
   ```

## Running Tests
1. **Run all tests**:
   ```sh
   mvn test
   ```
2. **View the test report**:
   - After running the tests, the reports can be found in the `test-output` directory.

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
- Test reports are generated in the `test-output` directory.
- The reports provide detailed information on the test results, including pass/fail status for each test case.

## Important Points
- Developed using Java, TestNG, and Rest Assured.
- Ensured adherence to proper coding standards.
- Comprehensive test coverage for both frontend and API functionalities.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

For any questions or issues, please contact the project maintainer.
