# Spring Boot Product Catalogue Microservice

## Overview
A REST API for managing a product catalogue, containerized and ready for scalable Kubernetes deployment. Implements versioning, CI/CD, and health monitoring.

---

## Versions
- **v1.0.0:** `/health`, `/products` endpoints
- **v1.1.0:** `/products/search?keyword=...`
- **v2.0.0:** `/products/search` supports `name`, `minPrice`, `maxPrice` with error handling

---

## Local Development
```bash
# Build and run with Maven
mvn clean package
java -jar target/*.jar

# API available at http://localhost:8080
```

---

## Docker Usage
```bash
# Build Docker image
# (replace <version> with v1.0.0, v1.1.0, or v2.0.0)
docker build -t your-dockerhub-username/spring-boot-crud-example:<version> .

# Run container
docker run -p 8080:8080 your-dockerhub-username/spring-boot-crud-example:<version>
```

---

## Kubernetes Deployment
```bash
# Create all namespaces
tkubectl apply -f k8s/namespace-v1.yaml
kubectl apply -f k8s/namespace-v1-1.yaml
kubectl apply -f k8s/namespace-v2.yaml

# Deploy all versions
kubectl apply -f k8s/

# Ensure NGINX ingress is installed
kubectl get ingress -A

# Access endpoints:
# http://localhost/v1/products
# http://localhost/v1.1/products/search?keyword=abc
# http://localhost/v2/products/search?name=abc&minPrice=10
```

---

## CI/CD Pipeline
- GitHub Actions workflow: `.github/workflows/ci-cd.yaml`
- On tag push (`v*.*.*`):
  - Builds & pushes Docker image
  - Deploys to Kubernetes
  - Runs health checks
- **Secrets required:**
  - `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN`
  - `KUBE_CONFIG_DATA` (base64 kubeconfig)

---

## Logging & Monitoring
- Health endpoint: `/health` (used for readiness/liveness probes)
- Logs available via `kubectl logs <pod> -n <namespace>`
- Add Prometheus/Grafana for advanced monitoring (optional)

---

## System Design
See [SYSTEM_DESIGN.md](SYSTEM_DESIGN.md) for architecture and design rationale.
 spring-boot-crud-example