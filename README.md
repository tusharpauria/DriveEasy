# DriveEasy — Car Rental Management System

DriveEasy is a backend REST API for managing rental cars. It is built using Spring Boot and provides APIs for car management, availability filtering, searching, pagination, validation, and soft deletion.

## Features

- Add, view and update cars
- Soft delete cars
- Filter available cars
- Search cars by brand
- Pagination
- Request validation
- Global exception handling
- MySQL persistence

## Tech Stack

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit & Mockito
- Postman
- Git & GitHub

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/cars` | Add a car |
| GET | `/cars` | Get active cars with pagination |
| GET | `/cars/{id}` | Get an active car by ID |
| PUT | `/cars/{id}` | Update a car |
| DELETE | `/cars/{id}` | Soft delete a car |
| GET | `/cars/available` | Get available cars |
| GET | `/cars/search?brand=Toyota` | Search cars by brand |

## Example Request

### Add Car

```json
{
    "brand": "Toyota",
    "model": "Fortuner",
    "pricePerDay": 2500,
    "available": true,
    "deleted": false
}

```
## Soft Delete

Cars are not permanently removed from the database. Instead, the `deleted` field is set to `true`, and normal API queries exclude deleted cars.

## Pagination

Example:

`GET /cars?page=0&size=5`

## Validation

- Brand cannot be blank
- Model cannot be blank
- Price per day must be greater than zero

Invalid requests return `400 Bad Request`.

## How to Run

1. Create a MySQL database named `driveeasy_db`.
2. Configure the database credentials in `application.properties`.
3. Open the project in IntelliJ IDEA.
4. Run `DriveEasyApplication`.
5. Test the APIs using Postman.
