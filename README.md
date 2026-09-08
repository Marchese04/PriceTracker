Price Tracker API

A Spring Boot REST API that monitors product prices across e-commerce stores and notifies users when a price drops below a target threshold.

🚧 Status: actively under development. Core CRUD for products is being implemented first, followed by the scraping engine, scheduler, and notification system.

Overview

Manually checking prices across multiple online stores is tedious. This project automates it: you register a product you want to track along with a target price, and the application periodically checks the current price and notifies you when it drops to (or below) that target.

Features
Product registration and management (CRUD)
Price history tracking (snapshots over time)
Scheduled price checks against external stores
Strategy-based scraping (pluggable per store)
Email notifications when target price is reached
API documentation via Swagger/OpenAPI
Tech Stack
Java 21
Spring Boot 3.3
Spring Web – REST API layer
Spring Data JPA – persistence layer
PostgreSQL – relational database
Bean Validation – request payload validation
Lombok – boilerplate reduction
Maven – dependency management

Planned additions: WebClient (external API calls), Flyway (schema migrations), Jsoup (scraping), Spring Mail (notifications), Spring Retry, Springdoc OpenAPI (Swagger UI), Testcontainers (integration tests).

Architecture

The project follows a feature-based package structure rather than a layer-based one. Each domain concept (e.g. product) owns its own entity, repository, service, controller, and DTOs, instead of scattering related code across generic controllers/, services/, repositories/ packages.

src/main/java/com/seunome/pricetracker/
├── PriceTrackerApplication.java
└── product/
├── Product.java              # JPA entity
├── ProductRepository.java    # data access
├── ProductService.java       # business logic
├── ProductController.java    # REST endpoints
└── dto/
├── ProductRequestDTO.java
└── ProductResponseDTO.java

Additional feature packages (pricehistory, scraper, notification, scheduler) will be added as those capabilities are implemented.

Getting Started
Prerequisites
Java 21+
Maven 3.9+
Docker (for running PostgreSQL locally)
Running locally
bash
# 1. Start the database
docker compose up -d

# 2. Run the application
./mvnw spring-boot:run

The API will be available at http://localhost:8080.

Configuration

Environment variables (see application.yml):

Variable	Description	Default
DB_USER	PostgreSQL username	pricetracker
DB_PASSWORD	PostgreSQL password	pricetracker
API Endpoints

Full documentation will be available via Swagger UI at /swagger-ui.html once implemented.

Method	Endpoint	Description
POST	/products	Register a new product to track
GET	/products	List all tracked products
GET	/products/{id}	Get a single product
PUT	/products/{id}	Update a tracked product
DELETE	/products/{id}	Stop tracking a product
Roadmap
Product CRUD (in progress)
Price snapshot persistence
Scraper for a single store (Strategy pattern)
Scheduled job comparing current price vs. target
Email notification on price match
Second store scraper
Unit and integration tests (Testcontainers)
Swagger documentation, Docker packaging, and live deployment
License

This project is for educational and portfolio purposes.