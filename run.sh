mvn clean install &&
docker build -f Dockerfile -t antoniosai/simple-crud-app:1.0.0 . &&
docker-compose up -d