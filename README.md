# Oil & Gas Field Operations System

Spring Boot REST backend implementing Project 5 with 16 entities, validated DTO-only APIs, soft deletion, business operations, custom queries, statistics, and centralized exception handling.

## Requirements
Java 21+, MySQL, Maven.

Set environment variables `DB_USERNAME` and `DB_PASS`, then run `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`). The database `oil_gas_operations` is created automatically when the configured MySQL account has permission.

## Domain
OilField, Well, Rig, Contractor, ProductionReading, Pipeline, StorageTank, Shipment, Customer, Equipment, MaintenanceRecord, Inspection, Personnel, Technician, Inspector, Incident.

Every normal resource exposes POST, GET-all, GET-by-id, PUT and soft DELETE. API requests/responses use DTOs and validation.

## Business API
`/operations` contains production recording, rig assignment, tank transfer, shipment dispatch, maintenance, inspections, incidents, production queries, producing wells, high-capacity tanks and field/contractor statistics.

Import the Postman files in `postman/` for a starter end-to-end business flow.

## Notes
Inspection scheduling uses a 90-day future window because the assignment requires a set window but does not specify its length. Schema screenshots must be captured locally from the Hibernate-generated MySQL schema.
