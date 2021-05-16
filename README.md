# snapshot

## Running the application

1. Start up the application: ``./gradlew bootRun``

2. Visit the application in your local browser: ```localhost:8080```

3. See the application endpoints in your local browser: ```localhost:8080/swagger-ui.html```

## Technical guide

### Database

The application relies on JPA (Java Persistence API) to communicate with an SQL database without having to define SQL queries manually.

For review table, we are using single table as an inheritance strategy for performance reasons.
