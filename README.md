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
1. Navigate to the following URL https://subscribe.stctv.com/sa-en  
2. Generate automated test to validate the Subscription Packages – Type & Price and Currency for all Countries (SA / 
Kuwait and Baharin)
3- Done using selenium among other frameworks 

### API Test
Sure, here's the explanation in a clearer and more understandable point form:

---

**Automated REST API Testing Project**

**Objective:**
Construct an automated test framework to test an Api to validate adding new devices using Rest Assured.

**Tools Used:**
- Programming Language: Java
- Testing Framework: Rest Assured with unit testing frameworks

**Tasks:**

1. **API Endpoint:**
   - `https://api.restful-api.dev/objects`

2. **Create Automation Script:**
   - **Add New Device:**
     - **Sample Request Payload:**
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
     - **Sample Response:**
       ```json
       {
         "id": "ff8081818fb998eb018fe89df1604c81",
         "name": "Apple Max Pro 1TB",
         "createdAt": "2021-06-05T13:36:56.161+00:00",
         "data": {
           "year": 2023,
           "price": 7999.99,
           "CPU model": "Apple ARM A",
           "Hard disk size": "1 TB"
         }
       }
       ```

3. **Validation:**
   - Validate the response to ensure the following fields are correct and not null:
     - `id`
     - `name`
     - `createdAt`
     - `year`
     - `price`
     - `CPU model`
     - `Hard disk size`

4. **Generate Report:**
   - Create a report indicating the pass/fail status of the test cases via TestNG.



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
