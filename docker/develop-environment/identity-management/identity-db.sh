#!/bin/bash

# Nazwa kontenera
CONTAINER_NAME="identity-dev-db"

# Sprawdzenie, czy kontener już istnieje
if docker ps -a --format "{{.Names}}" | grep -q "^$CONTAINER_NAME$"; then
    echo "Deleting old container: $CONTAINER_NAME"
    docker stop $CONTAINER_NAME > /dev/null 2>&1
    docker rm $CONTAINER_NAME > /dev/null 2>&1
fi

# Uruchomienie nowego kontenera
docker run -d \
--name $CONTAINER_NAME \
-e POSTGRES_USER=$SKYTRADER24_DEV_USERNAME \
-e POSTGRES_PASSWORD=$SKYTRADER24_DEV_PASSWORD \
-e POSTGRES_DB=identity-dev-db \
-v $PWD/src/main/resources/db/:/docker-entrypoint-initdb.d \
-p 5432:5432 \
postgres
echo "Created new container: $CONTAINER_NAME"