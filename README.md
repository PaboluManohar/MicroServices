# Microservices 🚀

Microservices architecture is an approach to software development where a large application is built as a collection of loosely coupled, independently deployable services. Each service is focused on a specific business capability and can be developed, deployed, and scaled independently.

## Services 🛠️

### UserService 💼

- The UserService handles user-related functionality such as user registration, authentication, profile management, and user data retrieval.
- It provides APIs for user creation, updating user information, authentication, and authorization.

### RatingService ⭐

- The RatingService manages the ratings and reviews for hotels.
- It allows users to submit ratings and reviews for hotels they have stayed in.
- It provides APIs for submitting ratings, retrieving ratings for a specific hotel, and calculating average ratings.

### HotelService 🏨

- The HotelService is responsible for managing hotel-related information such as hotel details, availability, and booking functionality.
- It provides APIs for searching hotels, retrieving hotel details, checking availability, and making bookings.

### ServiceRegistry 📝

- The ServiceRegistry acts as a central registry for all microservices in the architecture.
- It maintains a list of available services and their network locations (e.g., IP addresses, ports).
- It allows services to dynamically register and deregister themselves as they come online or go offline.

### APIGateway 🌐

- The APIGateway serves as a single entry point for clients to access the microservices.
- It acts as a reverse proxy that routes requests from clients to the appropriate microservice.
- It provides features such as authentication, authorization, rate limiting, and request/response transformation.
- It enables cross-cutting concerns such as logging, monitoring, and security to be centralized and applied consistently across all services.
