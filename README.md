# Movie API

## Dependencies
Docker, Kubectl, Minikube, Kustomization, Java11

## Quick Start in Kubernetes

* Start minikube  
`$ minikube start`

* Set docker to point to minikube  
`$ eval $(minikube docker-env)`
* Build docker image in minikube  
`$  docker build --tag=movie:0.0.1-SNAPSHOT .
`
* Build and apply manifests using Kustomization  
`$ kustomize build k8s/postgres | kubectl apply -f -`  
`$ kustomize build k8s/movie | kubectl apply -f -   `
* Get Portforwarding from minikube  
`$ minikube service movie-service
`

## Quick Start Local
* Initial postgres docker  
`$ docker pull postgres`  
`$ docker run --name my-postgres -p 5432:5432 -e POSTGRES_PASSWORD=pass -d postgres:latest`  
`$ docker exec -it my-postgres psql -U postgres` (optional: to psql into db)  
`$ spring-boot:run`
* End points are located in ` src/main/java/com/isanuric/movie/controller/`