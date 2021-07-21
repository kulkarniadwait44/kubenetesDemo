FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} demo-caller.jar
ENTRYPOINT ["java","-jar","/demo-caller.jar"]
EXPOSE 8086