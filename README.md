# Spring Transaction Propagation POC

This project demonstrates all Spring transaction propagation modes with simple `Account` balance updates and simulated mail logging.

## Stack
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## Configuration
Main config is in `src/main/resources/application.yaml` and defaults to:
- Host: `localhost:3306`
- DB: `spring_transaction`
- User: `root`
- Password: `root`

You can override with environment variables:
- `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD`

## Run
```bash
./gradlew bootRun
```

## Endpoints
- `GET /test/required`
- `GET /test/requires-new`
- `GET /test/supports`
- `GET /test/not-supported`
- `GET /test/mandatory`
- `GET /test/never`
- `GET /test/nested`
- `GET /test/accounts`

## Expected Highlights
- `REQUIRED`: outer + inner roll back together on exception.
- `REQUIRES_NEW`: inner commit survives even when outer fails.
- `SUPPORTS`: non-transactional caller executes directly.
- `NOT_SUPPORTED`: work executes outside transaction and survives outer rollback.
- `MANDATORY`: fails if no active transaction.
- `NEVER`: fails if transaction is active.
- `NESTED`: nested block rolls back to savepoint while outer can still commit (driver/DB support required).

