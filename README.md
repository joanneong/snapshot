# snapshot

## Running the application

1. Start up the application: ``./gradlew bootRun``

2. Visit the application in your local browser: ```localhost:8080```

3. See the application endpoints in your local browser: ```localhost:8080/swagger-ui.html```

## Technical guide

### Database

The application relies on JPA (Java Persistence API) to communicate with an SQL database without having to define SQL queries manually.

For review table, we are using single table as an inheritance strategy for performance reasons.

See the database structure using the in-memory H2 database at ```localhost:8080/h2```. Connect with the default settings 
(if that does not work, check that the settings are the same as configured in `application.properties`). This database is 
intended for proof-of-concept and unit testing.
