# Amaris Test

## What you need
- Java 8
- Maven
- You can also import the code straight into your IDE:
    - Spring Tool Suite (STS)
    - IntelliJ IDEA

## To skip the basics, do the following:
* download the source
* cd into amaris-test
* run: mvn clean install
 
## Run process
1. mvn spring-boot:run


## Endpoints

### Endpoint to save the person
> POST http://localhost:8090/person/v1/add

#### Example Request
```json
{
    "documentType": "C",
    "documentNumber": "123456",
    "firtsName": "Leonardo",
    "secondName": "Jose",
    "lastName": "Ruiz",
    "secondLastName": "Sanchez",
    "cellphone": "3102701621",
    "address": "avenida siempre viva"
}
```

#### Example Response
```json
{
    "code": 200,
    "message": "The person has been added to the database"
}
```
### Endpoint to get a person by documentType and documentNumber
> GET http://localhost:8090/person/v1/add/{documentType}/{documentNumber}

