# Movie API

## Dependencies and required tools
Maven, Java11, Docker, Kubectl, Minikube, Kustomization, 

## Quick Start in Kubernetes
* Run bash script and follow commands  
`$ bash ./start.sh`  
* Test it (create some entities and check REST API Documentation)  
  * `$ for i in {1..5}; do curl -X POST localhost/movie-random; echo; done`  
  * [REST API Documentation](http://localhost/swagger-ui.html)


For more details see `/start.sh` 

## Quick Start Local
* Initial postgres docker  
`$ docker pull postgres`  
`$ docker run --name postgres-local -p 5432:5432 -e POSTGRES_PASSWORD=Pass4321 -d postgres:latest`  
`$ docker exec -it my-postgres psql -U postgres` (optional: psql into db)  
`$ mvn spring-boot:run -Plocal`
* Test it (create some entities and check REST API Documentation)
    * `$ for i in {1..5}; do curl -X POST localhost:8080/movie-random; echo; done`
    * [REST API Documentation](http://localhost/swagger-ui.html)
