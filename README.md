# Plutocracy
#### Personal Finance Management System

##### Submission project for Technohack Hackathon 2021 under the Spoon theme Personal Finance Management System.

<center>
	<a target='_blank' href=''>CLICK HERE TO VIEW API DOCS (Deployed Swagger-UI)</a>
</center>

## Tech Stack Used 
* Java 15
* Spring Boot
* Spring Security (JWT Based Authentication and Authorization)
* Spring Data JPA/Hibernate
* PostgreSQL
* Open-API (Swagger-UI)
* Lombok

## Entities
![ER Diagram Of Entities](https://user-images.githubusercontent.com/69693621/119144218-182d8900-ba66-11eb-95d1-5fe24bbc3f6f.jpeg)

## Security Flow
* On Successful validation of login credentials, a JWT will be returned representing the user **(decode the below sample JWT on jwt.io for reference)**

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJkaWsuYmVobEB0aGVsYXR0aWNlLmluIiwiYWNjb3VudF9jcmVhdGlvbl90aW1lc3RhbXAiOnsieWVhciI6MjAyMSwibW9udGhWYWx1ZSI6NSwiZGF5T2ZNb250aCI6MTEsImhvdXIiOjIwLCJtaW51dGUiOjM1LCJzZWNvbmQiOjU1LCJuYW5vIjo2MDE4MDAwMDAsIm1vbnRoIjoiTUFZIiwiZGF5T2ZXZWVrIjoiVFVFU0RBWSIsImRheU9mWWVhciI6MTMxLCJjaHJvbm9sb2d5Ijp7ImNhbGVuZGFyVHlwZSI6Imlzbzg2MDEiLCJpZCI6IklTTyJ9fSwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJ1c2VyX2lkIjoiZWRlOThjZDAtYWFiZC00MDMzLTgwZmYtMWUxMWIxOTg3MDY1Iiwic2NvcGUiOiJ1c2VyIiwibmFtZSI6IkhhcmRpayBCZWhsIiwiZXhwIjoxNjIwNzgxNTgwLCJpYXQiOjE2MjA3NDU1ODAsImNvbnRhY3RfbnVtYmVyIjoiOTk5OTE1NTc4NiJ9.ktBeEMM4_FU-OLFJ6hxhLVqlYtMoPa0qZY2rjC8obic
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
* User's are able to set a **monthy spending threshold** and can track it through the month.
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



