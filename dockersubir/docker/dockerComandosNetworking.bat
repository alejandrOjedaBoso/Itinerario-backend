@echo off
docker stop postgrescontainer
docker stop springbootdockercontainer
docker stop dbeivercontainer
docker network rm postgresnetwork
docker rm postgrescontainer
docker rm springbootdockercontainer 
docker rm dbeivercontainer
docker rmi sprignbootpostgres

docker network create -d bridge --subnet 172.15.0.0/16 --gateway 172.15.0.1 postgresnetwork 
docker run -d -p 5432:5432 --network postgresnetwork --ip 172.15.0.2 --name postgrescontainer -e POSTGRES_PASSWORD=contrasena -e POSTGRES_USER=postgres -e POSTGRES_DB=test postgres:latest
docker build -t sprignbootpostgres:latest .
docker run -d -p 8080:8080 --network postgresnetwork --ip 172.15.0.3 --name springbootdockercontainer sprignbootpostgres:latest
docker run -d -p 8978:8978 --network postgresnetwork --ip 172.15.190.4 --name dbeivercontainer dbeaver/cloudbeaver:latest


echo "Terminado"
pause