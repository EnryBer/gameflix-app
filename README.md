# gameflix-app
Repository for GameFlix Project | HCDD 412

## Docker

### Build
mvn clean package
docker build -t gameflix-backend .

### Run
docker run --rm -p 8080:8080 --name gameflix-backend-container gameflix-backend

### Test
Use Postman to POST to:
http://localhost:8080/register
http://localhost:8080/login

## CI/CD (GitHub Actions)

This repo includes a simple CI workflow at `.github/workflows/ci.yml` that:
1) Checks out the code
2) Sets up Temurin JDK 17
3) Builds the project with Maven
4) Builds the Docker image (`gameflix-backend`)

To view runs: GitHub → Actions → "Spring Boot CI".
