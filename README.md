# products-user-manager
An API for product management and an API for user management with spring security.
This project is built with Java, Spring Boot, and Spring Framework.

## Features for the API main URL `/products`.

The product API provides HTTP endpoint's and tools for the following:

* Create a product: `POST/products/save`
* Delete a product (by id): `DELETE/products/{id}`
* Find a unique product by id: `GET/products/{id}`
* Find a unique product by name: `GET/products/{name}`
* Get all products: `GET/products/all`


## Features for the API main URL `/user`.

The user API provides HTTP endpoint's and tools for the following:

* Create a user: `POST/user/save`
* Find a unique user by username: `GET/user/{name}`
* Get all users: `GET/user/all`
