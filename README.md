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
