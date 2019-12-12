FROM adoptopenjdk/maven-openjdk11

# image layer
WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
FROM adoptopenjdk/openjdk11

EXPOSE 8080
COPY ./simple/target/simple-*.jar /developments/app.jar
ENTRYPOINT ["java","-jar","/developments/app.jar"]