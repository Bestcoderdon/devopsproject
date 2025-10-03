FROM openjdk:latest

COPY ./target/devopsproject-0.1.0.2-jar-with-dependencies.jar /tmp

WORKDIR /tmp

ENTRYPOINT ["java", "-jar", "devopsproject-0.1.0.2-jar-with-dependencies.jar"]