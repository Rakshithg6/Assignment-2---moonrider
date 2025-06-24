# Changelog

## v2.0.0
- Enhanced `/products/search` endpoint to support optional query parameters: `name` (partial match), `minPrice`, and `maxPrice`.
- Added error handling: returns 404 if no products match the criteria.

## v1.1.0
- Added `/products/search` endpoint to search products by keyword (name contains substring, case-insensitive).

## v1.0.0
- Initial version with `/health` endpoint for health checks.
- `/products` endpoint for listing all products.
- Basic CRUD endpoints for product catalogue management.
