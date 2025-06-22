## service-registry

`docker build --platform linux/amd64 -t aakashverma1124/service-registry .`

## product-service

`docker build --platform linux/amd64 -t aakashverma1124/product-service .`

## user-authentication-service

`docker build --platform linux/amd64 -t aakashverma1124/user-authentication-service .`

## api-gateway

`docker build --platform linux/amd64 -t aakashverma1124/api-gateway .`

## Run build-and-push.sh to build and push the docker images for all the services.

`chmod +x build-and-push.sh`

`./build-and-push.sh`

## docker exec

`docker exec -it user-authentication-db psql -U postgres -d user_authentication`

`docker exec -it product-db psql -U postgres -d products`
