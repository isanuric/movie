#!/bin/bash

# Start minikube
minikube start

# Set docker to point to minikube
eval $(minikube docker-env)

# Build docker image in minikube
mvn clean install -DskipTests
docker build --tag=movie:0.0.1-SNAPSHOT .

# Build and apply manifests using Kustomization
kubectl apply -f k8s/ingress/ingress.yaml
kustomize build k8s/postgres | kubectl apply -f -
kustomize build k8s/movie | kubectl apply -f -

# Enable ingress addon for minikube
minikube addons enable ingress

# Tunnel minikube
minikube tunnel
