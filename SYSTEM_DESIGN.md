# System Design: Product Catalogue Microservice

## Overview
This microservice manages a product catalogue for an e-commerce platform. It is designed for scalability, maintainability, and observability, and is suitable for cloud-native deployment.

---

## Architecture
- **Framework:** Spring Boot (Java)
- **REST Endpoints:**
  - `/health` — Health check
  - `/products` — CRUD operations
  - `/products/search` — Advanced search (v2.0)
- **Persistence:** JPA with RDBMS (H2, MySQL, etc.)
- **Containerization:** Multi-stage Docker build
- **Versioning:** Semantic version tags (v1.0.0, v1.1.0, v2.0.0)

---

## Versioning Strategy
- **v1.0.0:** Basic endpoints (`/health`, `/products`)
- **v1.1.0:** Add `/products/search` by keyword
- **v2.0.0:** Enhanced search with query params and error handling
- **Git tags** and `CHANGELOG.md` for traceability

---

## Deployment & Scalability
- **Kubernetes:**
  - Separate namespaces per version
  - Deployments with resource limits
  - Horizontal Pod Autoscaler (HPA) for traffic spikes
  - NGINX Ingress for version-based routing
- **CI/CD:**
  - GitHub Actions for build, Docker push, and K8s deploy

---

## Security & Observability
- **Secrets:** Use Kubernetes secrets for DB credentials and sensitive configs
- **Health checks:** `/health` endpoint for readiness/liveness
- **Logging:** Standard output, aggregated by Kubernetes
- **Monitoring:** Compatible with Prometheus/Grafana (extend as needed)

---

## Extensibility
- Add authentication/authorization (JWT, OAuth2)
- RBAC in Kubernetes for access control
- TLS for secure ingress traffic
- Infrastructure as Code (Terraform) for cluster provisioning

---

## Diagram (Textual)
```
[Client] ---> [Ingress Controller] ---> [Service (v1/v1.1/v2)] ---> [Pods]
                                              |
                                              v
                                         [Database]
```

---

## Notes
- Designed for rapid iteration and safe deployment of multiple API versions.
- Easily integrates with cloud CI/CD and monitoring solutions.
