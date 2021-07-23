cd demo
chmod +x ./mvnw
export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
export APPLICATION_PROPERTIES_HOSTNAME=""
./mvnw package && java -jar target/demo
docker build -t demo .
docker login -u "kulkarniadwait44" -p "Mimo#1234"
docker tag $(docker images demo --format "{{.ID}}") kulkarniadwait44/demo:1.0.0
docker push kulkarniadwait44/demo:1.0.0
docker apply -f service.yaml
docker apply -f deployment.yaml
kubectl expose deployment demo --type=NodePort --port=8085 --name=demo-service
