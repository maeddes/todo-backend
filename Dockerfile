FROM openjdk:8-alpine
RUN mkdir -p /opt/todolist
WORKDIR /opt/todolist
COPY target/todolist-0.0.1-SNAPSHOT.jar /opt/todolist
CMD ["java", "-jar", "todolist-0.0.1-SNAPSHOT.jar"]
