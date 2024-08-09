# Uber chargers
Services project to validate some basic chargers to check available chargers for electric uber cars.

## Functional Requirement
A set of services must be implemented to: get a charger status, get list of available chargers.

It is expected to have a minimum of two services:
* New session: The server generates and returns an identifier that represents the active session of the client.
* Check available chargers: A list chargers with available status to be assigned to a user with an electric car.
* Get charger by id: A charger with his fields. 

The services must respond to the following flow:
* The client calls a service to start (New session).
* The client calls a service to check chargers, as many times as you like.
* The client calls a service to find a charger. 

You must take into account that:
* You can check “n” calls for to validate available chargers.
* The result expected is to find an assign a charger to a user with a electric car.

## Requirements

Java JDK 1.8
Maven 3

## Build
```
mvn clean install
```

## Run
```
mvn spring-boot:run
```
## Docker
```
docker build -t api-uber-chargers-1.0.0 .
docker run -p 8080:8080 api-uber-chargers-1.0.0
```

## Api documentation with Swagger

```
localhost:8080/swagger-ui.html
```

## Services

### Get session
```
http://localhost:8080/api/charger/session
```

### Get available chargers
```
http://localhost:8080/api/charger/available
```

### Get a charger by id 
```
http://localhost:8080/api/charger/{id}
```

### Register a charger
```
http://localhost:8080/api/charger/{id}
```

### Demo

![Find and check charger ](demo/demo.gif)

### Development notes
* The project was developed in Java 8 using spring boot
* The handling of the session is managed directly when generating the request from the client so that different sessions are maintained for multiple clients
* Once the project is up, the persisted SQL table is created and deleted
* The port used for the project is 8080
* The project's own configurations can be consulted in the application.yml file

### Statement Notes
The main quality attributes that I highlight are:
* Simplicity in design and use
* Modifiability and maintainability
* Self-documented code 
  
About the design pattern, I used the MVC pattern perhaps because of my familiarity with it.
