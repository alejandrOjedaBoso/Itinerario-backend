@echo off
docker stop postgrescontainer
docker stop springbootdockercontainer 
docker network rm postgresnetwork
docker rm postgrescontainer
docker rm springbootdockercontainer 
docker rmi sprignbootpostgres

docker network create postgresnetwork 
docker run -d --network postgresnetwork --name postgrescontainer -e POSTGRES_PASSWORD=contrasena -e POSTGRES_USER=postgres -e POSTGRES_DB=test postgres:latest
docker build -t sprignbootpostgres:latest .
docker run -d --network postgresnetwork  --name springbootdockercontainer sprignbootpostgres:latest
echo "Terminado"
pause