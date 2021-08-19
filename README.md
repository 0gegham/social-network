## Social-Network Application with microservices architecture

`api-zuul-proxy`: Reverse proxy service that is used to forward requests to other service applications, also provides authentication via spring security and jwt.
***
`config-server`: Config server for externalized configuration in a distributed system. That means with this server we have a central place to manage external properties for applications across all environments
***
`conversations-service`: Provides API for user-conversations management
***
`friends-service`: Provides API for user-friends management
***
`Messages-service`: Service used for messages management. Send, remove and get. Used RabbitMQ message-broker.
***
`picture-service`: Provides API for user-picture management
***
`service registry`: Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.
***
`user-service`: Provides API for user management.
***

Each service has its own simple Dockerfile. For Running all services, I may change configurations (such as db username and password or repository for config-server) and simply write `docker-compose up`