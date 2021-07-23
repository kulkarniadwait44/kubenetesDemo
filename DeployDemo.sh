cd demo
chmod +x ./mvnw
export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
export APPLICATION_PROPERTIES_HOSTNAME=""
./mvnw package && java -jar target/demo
docker build -t demo .
docker login -u "kulkarniadwait44" -p "Mimo#1234"
docker tag $(docker images demo --format "{{.ID}}") kulkarniadwait44/demo:1.0.0
docker push kulkarniadwait44/demo:1.0.0
cd /demo
kubectl apply -f service.yaml
kubectl apply -f deployments.yaml
#kubectl expose deployment demo --type=NodePort --port=8085 --name=demo-svc
cd ..
cd demo-caller
chmod +x ./mvnw
./mvnw package && java -jar target/demo-caller
docker build -t demo-caller .
docker tag $(docker images demo-caller --format "{{.ID}}") kulkarniadwait44/demo-caller:1.0.0
docker push kulkarniadwait44/demo-caller:1.0.0
kubectl apply -f service.yaml
kubectl apply -f deployments.yaml
#kubectl expose deployment demo-caller --type=NodePort --port=8085 --name=demo-svc
