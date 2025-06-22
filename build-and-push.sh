#!/bin/bash

# Set docker username once
DOCKER_USERNAME=aakashverma1124

# Build list of services
services=(
  service-registry
  product-service
  user-authentication-service
  api-gateway
)

# Loop through each service
for service in "${services[@]}"
do
  echo "========================================"
  echo "Building $service"
  echo "========================================"

  cd $service || { echo "Directory $service not found! Skipping..."; continue; }

  docker build -t $DOCKER_USERNAME/$service .

  if [ $? -eq 0 ]; then
    echo "✅ Build success: $DOCKER_USERNAME/$service"
    echo "Pushing $DOCKER_USERNAME/$service to Docker Hub..."
    docker push $DOCKER_USERNAME/$service
  else
    echo "❌ Build failed: $service"
  fi

  cd ..

done

echo "🎉 All builds and pushes complete!"
