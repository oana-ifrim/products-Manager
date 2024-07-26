# An API for product management and an API for user management with spring security.

The product API provides HTTP endpoint's and tools for the following:

Create a product: POST/products/save
Delete a product (by id): DELETE/products/{id}
Find a unique product by id: GET/products/{id}
Find a unique product by name: GET/products/{name}
Get all products: GET/products/all

The user API provides HTTP endpoint's and tools for the following:

Create a user: POST/user/save
Find a unique user by username: GET/user/{name}
Get all users: GET/user/all
