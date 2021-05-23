# Plutocracy
#### Personal Finance Management System

##### Submission project for Technohack Hackathon 2021 under the Spoon theme Personal Finance Management System.

<center>
	<a target='_blank' href='https://plutocracy.herokuapp.com/plutocracy/swagger-ui.html'>CLICK HERE TO VIEW API DOCS (Deployed Swagger-UI)</a>
</center>

## Tech Stack Used 
* Java 15
* Spring Boot
* Spring Security (JWT Based Authentication and Authorization)
* Spring Data JPA/Hibernate
* PostgreSQL
* Open-API (Swagger-UI)
* Lombok
* Figma

## Entities
##### SQL Migration Scripts can be viewed at src/main/resources/db/migration
##### Read in detail about entities used in ENTITIES.md in project root.
![ER Diagram of Database Entities](https://user-images.githubusercontent.com/69693621/119250906-e7159b80-bbc0-11eb-930d-944714b986f6.jpeg)


## Security Flow
* On Successful validation of login credentials, a JWT will be returned representing the user **(decode the below sample JWT on jwt.io for reference)**

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJkaWsuYmVobDc0NDRAZ21haWwuY29tIiwiYWNjb3VudF9jcmVhdGlvbl90aW1lc3RhbXAiOiIyMDIxLTA1LTIyVDExOjIyOjE5LjQ5MTQ4NiIsInVzZXJfaWQiOiIzODQ3ZjYxYy1hNjc0LTQ0N2UtYmQ0ZC0wZThhODk3NTg2YmQiLCJ0b3RhbF9iYWxhbmNlX2lkIjoiMWQyZWNiMzctMDNkNS00YjhhLWI0Y2MtMDllZTBmYjQwMDM3Iiwic2NvcGUiOiJ1c2VyIiwibmFtZSI6IkhhcmRpayBCZWhsIiwiZXhwIjoxNjIxNzA4NDE0LCJpYXQiOjE2MjE2NzI0MTR9.XaqcTVYUuBIBtp74pJK-_mTtQCYMWdduoWGoYhsSxD4
```
* The received JWT should be included in the headers when calling a protected API
* Authentication Bearer format to be used **(Header key should be 'Authentication' and value should start with Bearer followed with a single blank space and recieved JWT)**

```
Authentication : Bearer <JWT>
```

## Main Features
* User's are able to register themselves with the application **(register/login/update-details/change-password)**
* User's are able to manage and track their balance across different **modes**
* User's are able to track their **current** expenses/gains.
* User's are able to track their **upcoming (future)** expenses/gains.
* User's are able to set **financial goals** and track their completion.
* User's are able to set a **monthy spending threshold** and can track it through the month. (calculated automatically at month end using Spring scheduler and cron expressions)
* User's are able to create financial **notes** for their reference.
* User's are able to assign **tags** to their expenses/gains tickets or notes for future reference and quering


## Setup Locally Without Docker

* Install Java 15
* Install Maven
* Install PostgreSQL

Recommended way is to use [sdkman](https://sdkman.io/) for installing both maven and java

Create postgres user (superuser) with name and password as plutocracy

```
CREATE USER plutocracy WITH PASSWORD 'plutocracy' SUPERUSER;
```
Create Database with name 'plutocracy' and assign the above created user to the database with preferable CLI or GUI tool

```
create database plutocracy;
```

```
grant all privileges on database plutocracy to plutocracy;
```

Run the below commands in the core

```
mvn clean
```

```
mvn install
```

Execute any of the two commands below to run the application

```
java -jar target/url-shortner-h2-db-0.0.1-SNAPSHOT.jar
```

```
mvn spring-boot:run
```

The Default port is 9090 and base-url is set to /plutocracy (both can be changed in application.properties)

Go to the below URI to view Swagger-UI (API-docs)

```
http://localhost:9090/plutocracy/swagger-ui.html
```

---

## Setup With Docker
* Install Java 15
* Install Maven

Recommended way is to use [sdkman](https://sdkman.io/) for installing both maven and java

Run mvn clean install in the core

```
mvn clean install
```

Run docker commands

```
sudo docker-compose build
sudo docker-compose up -d
```

Service port is 9090 and Postgres Port is 6432. They both can be changed in the [docker-compose.yml](docker-compose.yml) file

To View Logs

```
docker-compose logs -f service
```

To stop the container run

```
sudo docker-compose stop
```

Go to the below URI to view Swagger-UI (API-docs)

```
http://localhost:9090/plutocracy/swagger-ui.html
```

## Quick Guide To Use Swagger-UI

* Click on API that you wish to hit by clicking the **Try It Out** button
* Fill in the input if required as mentioned and click on **execute**
* Some API's do not require the user to authenticate themselves before using it like account-registeration/account-login API's
* In order to gain JWT required for authentication, execute the login API with valid credentials and paste the received JWT in repsonse in the Top Right section y clicking on **Authorize** and paste the JWT there to authorize
* After successfully authorization, all protected API's can be executed the same way non-protected API's were being executed, the JWT will be **automatically** sent to the server inside headers following **bearerAuth** security flow. 

