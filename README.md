# Quick Start

* Start minikube  
`$ sinikube start`

* Set docker to point to minikube  
`$ eval $(minikube docker-env)`
* Build docker image in minikube  
`$  docker build --tag=movie:0.0.1-SNAPSHOT .
`
* Build and apply manifests using Kustomization  
`$ kustomize build k8s | kubectl apply -f -   `
* Get Portforwarding from minikube  
`$ minikube service movie-service
`