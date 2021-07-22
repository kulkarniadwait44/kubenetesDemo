cd demo
chmod +x ./mvnw
export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
./mvnw package && java -jar target/demo
docker build -t demo .
docker login -u "kulkarniadwait44" -p "Mimo#1234"
<<<<<<< HEAD

=======
>>>>>>> a8c4c229e3a568b156633edbf576c086047c57bd
