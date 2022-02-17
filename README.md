# Movie API

## Dependencies and required tools
Docker, Kubectl, Minikube, Kustomization, Java11

## Quick Start in Kubernetes
* Run bash script and follow commands  
`$ bash ./start.sh`  
* Test it (create some entities)  
`$ for i in {1..5}; do curl -X POST localhost/save-random; echo; done`

For more details see `/start.sh` 

## Quick Start Local
* Initial postgres docker  
`$ docker pull postgres`  
`$ docker run --name postgres-local -p 5432:5432 -e POSTGRES_PASSWORD=Pass4321 -d postgres:latest`  
`$ docker exec -it my-postgres psql -U postgres` (optional: psql into db)  
`$ mvn spring-boot:run -Plocal`
* Test it (create some entities)  
`$ for i in {1..5}; do curl -X POST localhost:8080/save-random; echo; done`