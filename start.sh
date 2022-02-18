#!/bin/bash

# Start minikube
modus=$1
echo $modus
if [[ $modus != "minikube-active" ]]; then
  minikube start
fi

# Set docker to point to minikube
eval $(minikube docker-env)

# Docker
mvn clean install
docker build --tag=movie:0.0.1-SNAPSHOT .

# Build and apply manifests
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
  sleep 15
  for i in {1..10}; do curl -X POST localhost/save-random; echo; done
fi
