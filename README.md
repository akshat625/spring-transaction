# Spring Transaction Propagation POC

This project demonstrates all Spring transaction propagation modes with simple `Account` balance updates and simulated mail logging.

## Stack
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok


## Run
```bash
./gradlew bootRun
```

## Endpoints
- `GET /required`
- `GET /requires-new`
- `GET /supports`
- `GET /not-supported`
- `GET /mandatory`
- `GET /never`
- `GET /nested`
- `GET /accounts`

## Expected Highlights
- `REQUIRED`: outer + inner roll back together on exception.
- `REQUIRES_NEW`: inner commit survives even when outer fails.
- `SUPPORTS`: non-transactional caller executes directly.
- `NOT_SUPPORTED`: work executes outside transaction and survives outer rollback.
- `MANDATORY`: fails if no active transaction.
- `NEVER`: fails if transaction is active.
- `NESTED`: nested block rolls back to savepoint while outer can still commit (driver/DB support required).

