#!/bin/bash

# Start minikube
modus=$1
echo $modus
if [[ $modus != "minikube-active" ]]; then
  minikube start
fi


# Set docker to point to minikube
eval $(minikube docker-env)


# Build docker image in minikube
if [[ $modus == "minikube-active" ]]; then
  docker rmi -f movie:0.0.1-SNAPSHOT
fi

mvn clean install -DskipTests
docker build --tag=movie:0.0.1-SNAPSHOT .


# Build and apply manifests using Kustomization
if [[ $modus != "minikube-active" ]]; then
  kubectl apply -f k8s/movie/secret.yaml
fi

kubectl apply -f k8s/ingress/ingress.yaml
kustomize build k8s/postgres | kubectl apply -f -
kustomize build k8s/movie | kubectl apply -f -


# Enable ingress addon for minikube
if [[ $modus != "minikube-active" ]]; then
  minikube addons enable ingress
  # Tunnel minikube
  minikube tunnel
else
  echo
  sleep 20
  for i in {1..10}; do curl -X POST localhost/movie/save-random; echo; done
fi
