# Hotel Management Microservices

This project is a microservices-based architecture for managing hotel operations. It consists of three main services: **UserService**, **HotelService**, and **RatingService**. The services are designed to handle user management, hotel information, and ratings, respectively, and are integrated using Spring Cloud components for resilience and scalability.

## Table of Contents

- [Features](#features)
- [Microservices](#microservices)
  - [UserService](#userservice)
  - [HotelService](#hotelservice)
  - [RatingService](#ratingservice)
- [Setup](#setup)
- [Commit History](#commit-history)
- [Author](#author)

## Features

- **API Gateway**: Centralized routing for all microservices, implemented with Spring Cloud Gateway.
- **Service Discovery with Eureka**: Dynamic service registration and discovery.
- **Resilience4j Integration**: Circuit breaker and rate limiter patterns to handle failures and control traffic.
- **Feign Client**: Simplifies inter-service communication with declarative REST clients.
- **Centralized Configuration**: Externalized configuration management using Spring Cloud Config Server.

## Microservices

### UserService

Manages user-related operations, including retrieving and saving user data.

#### Endpoints

- **Get All Users**
  - **URL**: `GET /user/getAll`
  - **Description**: Retrieves a list of all users.
  
- **Get User by Username**
  - **URL**: `GET /user/username/{username}`
  - **Description**: Retrieves a user by their username. Uses Circuit Breaker for resilience.

- **Save a New User**
  - **URL**: `POST /user/save`
  - **Description**: Saves a new user.
  
- **Save Multiple Users (Dummy Data)**
  - **URL**: `POST /user/dummydata`
  - **Description**: Saves multiple users in a single request.

### HotelService

Handles hotel information and operations.

#### Endpoints

- **Get Hotel by ID**
  - **URL**: `GET /hotel/get-hotel/{hotelId}`
  - **Description**: Retrieves details of a specific hotel by its ID.
  
- **Get All Hotels**
  - **URL**: `GET /hotel/get-all-hotel`
  - **Description**: Retrieves a list of all hotels.
  
- **Create a New Hotel**
  - **URL**: `POST /hotel/create-hotel`
  - **Description**: Creates a new hotel entry.
  
- **Create Multiple Hotels**
  - **URL**: `POST /hotel/create-listof-hotel`
  - **Description**: Inserts multiple hotels in a single request.

### RatingService

Manages ratings and reviews for hotels.

#### Endpoints

- **Create a Single Rating**
  - **URL**: `POST /rating/create-rating`
  - **Description**: Creates a new rating for a hotel.
  
- **Create Multiple Ratings**
  - **URL**: `POST /rating/create-multiple-rating`
  - **Description**: Creates multiple ratings in a single request.
  
- **Get All Ratings**
  - **URL**: `GET /rating/get-all-rating`
  - **Description**: Retrieves all ratings.
  
- **Get Ratings by User ID**
  - **URL**: `GET /rating/get-rating-by-userid/{userName}`
  - **Description**: Retrieves all ratings made by a specific user.
  
- **Get Ratings by Hotel ID**
  - **URL**: `GET /rating/get-rating-by-hotelid/{hoteID}`
  - **Description**: Retrieves all ratings for a specific hotel.

## Setup

### Prerequisites

- JDK 17 or above
- Maven 3.6+
- MySQL Database
- Config Server
- Eureka Server

### Running the Microservices

1. **Clone the Repository**
   ```bash
   git clone https://github.com/iamkgehlot/HotelMicroservices.git
   cd HotelMicroservices
   ```

2. **Set Up the Database**
   Update the `application.properties` or `application.yml` files for each service with your MySQL database details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   ```

3. **Start the Eureka Server**
   Navigate to the Eureka Server directory and run the application:
   ```bash
   mvn spring-boot:run
   ```

4. **Start the Config Server**
   Ensure that the Config Server is running to provide configuration to all services.

5. **Start the Microservices**
   Navigate to each microservice directory (UserService, HotelService, RatingService) and run:
   ```bash
   mvn spring-boot:run
   ```

6. **Run the API Gateway**
   Start the API Gateway to route requests to the appropriate services:
   ```bash
   mvn spring-boot:run
   ```

## Commit History

Here are some of the notable commits:

- **Added Resilience4j Circuit Breaker Configuration to UserService**
  - Added resilience features for better fault tolerance.

- **Implemented API Gateway for all routes**
  - Set up centralized routing for all microservices.

- **Added Feign Client and Eureka Server configuration**
  - Integrated Feign Client for inter-service communication and Eureka Server for service discovery.

- **Created Rating Service**
  - Implemented the service for managing hotel ratings.

- **Created Hotel Service**
  - Developed functionality for managing hotel information.

- **Created User Service**
  - Built the user management service for handling user data.

## Author

Kamlesh Gehlot - [iamkgehlot](https://github.com/iamkgehlot)
