
## -------------------------first proposition to buidl docker images -------------------
## NB: For te first proposition , first run mvn clean package before to buid images and then take the name of jar file for the utilization of  building images

# 1. Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# 2. Set a working directory in the container
WORKDIR /app

# 3. Copy the JAR file from the host to the container
COPY target/*.jar app.jar

#Or use thsi command this specified jar file
#COPY target/jenkins-deploy-0.0.1-SNAPSHOT.jar app.jar

# 4. Expose a port to enable communication with the container
EXPOSE 8082

# 5. Set an environment variable (optional)
ENV JAVA_OPTS=""

# 6. Define the command to run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]







## ----------- Second proposition to buidl docker images when you're building docker images with running maven -------------------

#FROM maven:3.8.3-openjdk-17 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#WORKDIR /home/app
#RUN mvn clean package -Dmaven.test.skip=true # Build jar file

## Stage 2: Create the final Docker image

#FROM openjdk:17-jdk
#COPY --from=build /home/app/target/*.jar jenkins-deploy.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "jenkins-deploy.jar"]