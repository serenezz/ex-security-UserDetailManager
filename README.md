# Exercise: UserDetailsManager with H2 Database using Spring Boot

This exercise demonstrates user management with roles using `UserDetailsManager` from Spring Security, backed by an H2 in-memory database.

## Endpoints

- **GET /api**: Returns the username of the authenticated user.
- **GET /api/manager**: Requires ROLE_MANAGER or ROLE_ADMIN role to access. Returns the role of the authenticated user.
- **GET /api/admin**: Requires ROLE_ADMIN role to access. Returns a message indicating only admins have access.

## Configuration

### UserDetailsConfig.java

- Sets up an embedded H2 database (`userDB`).
- Initializes users (manager and admin) with roles using `JdbcUserDetailsManager`.

### SecurityConfig.java

- Enables Spring Security with basic configurations.
- Defines security rules for HTTP requests, requiring authentication for all endpoints.