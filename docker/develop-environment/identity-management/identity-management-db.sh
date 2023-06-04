docker run -d \
--name identity-management-dev-db \
-e POSTGRES_USER=$SKYTRADER24_DEV_USERNAME \
-e POSTGRES_PASSWORD=$SKYTRADER24_DEV_PASSWORD \
-e POSTGRES_DB=identity-management-dev-db \
-v $PWD/src/main/resources/db/:/docker-entrypoint-initdb.d \
-p 5432:5432 \
postgres